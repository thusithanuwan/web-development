import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Customer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReadJson1 {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        Customer customer = gson.fromJson(new FileReader("Customer.json"), Customer.class);
        System.out.println(customer);

        Type customerListType  = new TypeToken<List<Customer>>() {}.getType();

//        List<Customer> customerList = gson.fromJson(new FileReader("CustomerList.json"), List.class);
        List<Customer> customerList = gson.fromJson(new FileReader("CustomerList.json"), customerListType);
        List<Customer> customerList1 = gson.fromJson(new FileReader("CustomerList.json"), new ArrayList<Customer>(){}.getClass().getGenericSuperclass());





        System.out.println(customerList.get(0));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(customerList1.get(0));


    }
}
