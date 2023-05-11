import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.*;

public class ReadJson2 {
    public static void main(String[] args) throws FileNotFoundException {

        JsonReader reader = Json.createReader(new FileReader("jakarta-ee--jsonp-2.json"));
        JsonObject jsonObject = reader.readObject();
        String name = jsonObject.getString("name");
        System.out.println(name);
        int address = jsonObject.getJsonObject("address").getInt("no");
        System.out.println(address);
        JsonArray contact = jsonObject.getJsonArray("contact");
        System.out.println(contact);

    }
}
