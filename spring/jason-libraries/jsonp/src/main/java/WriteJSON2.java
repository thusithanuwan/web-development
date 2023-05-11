import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;
import jakarta.json.stream.JsonGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class WriteJSON2 {


    /*
    *  {
    *       "id":"C001"
    *       "name":"kasun sampath",
    *       "address": "panadura",
    *       "age":"17"
    *   }
    * */

    public static void main(String[] args) throws IOException {
        JsonObject json = Json.createObjectBuilder()
                .add("id", "C001")
                .add("name", "kasun sampath")
                .add("address", Json.createObjectBuilder().add("no",15)
                        .add("street","grace peries road").build())
                .add("age", "17")
                .add("contact",Json.createArrayBuilder().add("077534243").add("4932498592359").build())
                .build();

            Json.createWriter(System.out)
                    .write(json);

        HashMap<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true); // To get nice format
        JsonWriter writer = Json.createWriterFactory(config).createWriter(new FileWriter("jakarta-ee--jsonp-2.json"));
//        JsonWriter writer = Json.createWriter(new FileWriter("jakarta-ee--jsonp-2.json"));
        writer.write(json);
        writer.close();


    }
}
