package lk.ijse.dep10.pos.api;

import lk.ijse.dep10.pos.dto.CustomerDTO;
import lk.ijse.dep10.pos.dto.ItemDTO;
import lk.ijse.dep10.pos.dto.ResponseErrorDTO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {

    @Autowired
    private BasicDataSource pool;


    // GET http://localhost:8080/pos/customers?q=Gallse
    @GetMapping
    public ResponseEntity<?> getCustomers(@RequestParam(value = "q", required = false) String query){
        if (query == null) query = "";
        try(Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("select * from item where code like ? or description like ? or quantity like ? or price like ?");
            query = "%" + query + "%";
            for (int i = 1; i <= 4; i++) {
                stm.setString(i,query);
            }
            ResultSet rst = stm.executeQuery();
            List<ItemDTO> ItemList = new ArrayList<>();
            while (rst.next()){
                int code = rst.getInt("code");
                String description = rst.getString("description");
                int quantity = rst.getInt("quantity");
                BigDecimal price = rst.getBigDecimal("price");
                ItemList.add(new ItemDTO(code,description,quantity,price));
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-count", ItemList.size() + "");
            return new ResponseEntity<>(ItemList,headers,HttpStatus.OK);

        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseErrorDTO(500,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity saveItem(@RequestBody ItemDTO item) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = pool.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("insert into item (description,quantity,price) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, item.getDescription());
            stm.setInt(2, item.getQuantity());
            stm.setBigDecimal(3, item.getPrice());
            stm.executeUpdate();

            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            int code = generatedKeys.getInt(1);
            item.setCode(code);
            return new ResponseEntity(item, HttpStatus.CREATED);


        } catch (SQLException e) {

            if (e.getSQLState().equals("23000")) {
                return new ResponseEntity(new ResponseErrorDTO(HttpStatus.CONFLICT.value(),
                        e.getMessage()), HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity(new ResponseErrorDTO(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }


    }
}
