package lk.ijse.dep10;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyOrderStrategy;
import lk.ijse.dep10.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteJson {
    public static void main(String[] args) throws IOException {

        Student student1 = new Student(1, "Ruwan");
        Student student2 = new Student(2, "Nuwan");
        Student student3 = new Student(3, "Gayan");

        List<Student> studentList = List.of(student1,student2,student3);


        JsonbConfig config = new JsonbConfig();
        config.withFormatting(true);
        config.withPropertyNamingStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL);

        Jsonb jsonb = JsonbBuilder.create();     // if we pass config object we can get formatted json object
//        String json = jsonb.toJson(student1);
        String json = jsonb.toJson(studentList);
        System.out.println(json);

        jsonb.toJson(studentList, new FileWriter("student-list.json"));

    }
}
