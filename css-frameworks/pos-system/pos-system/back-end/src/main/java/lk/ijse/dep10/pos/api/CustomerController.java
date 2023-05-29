package lk.ijse.dep10.pos.api;

import lk.ijse.dep10.pos.dto.CustomerDTO;
import lk.ijse.dep10.pos.dto.ResponseErrorDTO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin           // like to share resouces with any origin
//@CrossOrigin {origin = {'http://google.com'}}
public class CustomerController {

    @Autowired
    private BasicDataSource pool;







    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") int customerId, @RequestBody CustomerDTO customer) {
        try(Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("update customer set name=?, address=? , contact = ? where id=?");
            stm.setString(1,customer.getName());
            stm.setString(2,customer.getAddress());
            stm.setString(3,customer.getContact());
            stm.setInt(4,customerId);
            int affectedRows = stm.executeUpdate();
            if (affectedRows == 1){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                ResponseErrorDTO error = new ResponseErrorDTO(404, "Customer ID not found!");
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            }


        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) {
                return new ResponseEntity(new ResponseErrorDTO(HttpStatus.CONFLICT.value(),
                        e.getMessage()), HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity(new ResponseErrorDTO(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String customerId) {
        try (Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("delete from customer where id=?");
            stm.setString(1, customerId);
            int affectedRows = stm.executeUpdate();
            if (affectedRows == 1) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                ResponseErrorDTO response = new ResponseErrorDTO(404, "Invalid Customer ID");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }


        } catch (SQLException e) {

            if (e.getSQLState().equals("23000")) {
                return new ResponseEntity(new ResponseErrorDTO(HttpStatus.CONFLICT.value(),
                        e.getMessage()), HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity(new ResponseErrorDTO(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    // GET http://localhost:8080/pos/customers?q=Gallse
    @GetMapping
    public ResponseEntity<?> getCustomers(@RequestParam(value = "q", required = false) String query) {


        if (query == null) query = "";
        try (Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("select * from customer where id like ? or name like ? or address like ? or contact like ?");
            query = "%" + query + "%";
            for (int i = 1; i <= 4; i++) {
                stm.setString(i, query);
            }
            ResultSet rst = stm.executeQuery();
            List<CustomerDTO> customerList = new ArrayList<>();
            while (rst.next()) {
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                String contact = rst.getString("contact");
                customerList.add(new CustomerDTO(id, name, address, contact));
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-count", customerList.size() + "");
            return new ResponseEntity<>(customerList, headers, HttpStatus.OK);

        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseErrorDTO(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customer) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("insert into customer (name,address,contact) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, customer.getName());
            stm.setString(2, customer.getAddress());
            stm.setString(3, customer.getContact());
            stm.executeUpdate();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            int id = generatedKeys.getInt(1);
            customer.setId(id);
            return new ResponseEntity(customer, HttpStatus.CREATED);

        } catch (SQLException e) {
//            System.out.println(e.getSQLState());

            if (e.getSQLState().equals("23000")) {
                return new ResponseEntity(new ResponseErrorDTO(HttpStatus.CONFLICT.value(),
                        e.getMessage()), HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity(new ResponseErrorDTO(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }
    }
}
