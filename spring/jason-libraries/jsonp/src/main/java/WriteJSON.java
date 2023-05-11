import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteJSON {


    /*
    *  {
    *       "id":"C001"
    *       "name":"kasun sampath",
    *       "address": "panadura",
    *       "age":"17"
    *   }
    * */

    public static void main(String[] args) {
        JsonObject json = Json.createObjectBuilder()
                .add("id", "C001")
                .add("name", "kasun sampath")
                .add("address", Json.createObjectBuilder().add("no",15)
                        .add("street","grace peries road").build())
                .add("age", "17")
                .add("contact",Json.createArrayBuilder().add("077534243").add("4932498592359").build())
                .build();

        System.out.println(json);
        File file = new File("jakarta-ee--jsonp.json");
        try(FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(json.toString());


        }catch (IOException e){
            throw  new RuntimeException(e);
        }




    }
}
