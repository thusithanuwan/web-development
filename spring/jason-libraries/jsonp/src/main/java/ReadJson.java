import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.*;

public class ReadJson {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("jakarta-ee--jsonp-2.json"));
            String line;
            String json = "";
            while ((line = bufferedReader.readLine()) != null){
                json += line + "\n";
            }
            System.out.println(json);

            JsonReader reader = Json.createReader(new StringReader(json));
//            String name = reader.readObject().getString("name");
//            System.out.println(name);
//            String contact = Json.createReader(new StringReader(json)).readObject().getJsonArray("contact").getString(0);
//            System.out.println(contact);

            JsonObject jsonObject = reader.readObject();
            String name = jsonObject.getString("name");
            String address = jsonObject.getJsonObject("address").getString("no");
            System.out.println(address);
            JsonArray contact = jsonObject.getJsonArray("contact");
            System.out.println(contact);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
