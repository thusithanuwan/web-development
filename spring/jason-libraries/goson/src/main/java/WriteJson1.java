import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteJson1 {
    public static void main(String[] args) throws IOException {


        Customer c1 = new Customer(1, "Kasun", "Galle","jio");
        Customer c2 = new Customer(1, "Rasun", "Kandy","jkds");
        Customer c3 = new Customer(1, "Nasun", "Colombo","dsf");
        Customer c4 = new Customer(1, "Lasun", "Galle","jfdk");

        List<Customer> custoerList = List.of(c1, c2, c3, c4);

        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();
//        String json = gson.toJson(c1);
        String json = gson1.toJson(custoerList);
        System.out.println(json);

        FileWriter fileWriter = new FileWriter("Customer.json");
        gson1.toJson(c1, Customer.class, fileWriter);
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter("CustomerList.json");
        gson1.toJson(custoerList, List.class, fileWriter1);
        fileWriter1.close();



    }
}
