package lk.ijse.dep10;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.dep10.model.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadJson2 {
    public static void main(String[] args) throws FileNotFoundException {
        Jsonb jsonb = JsonbBuilder.create();

        Student student = jsonb.fromJson(new FileReader("student.json"), Student.class);
        System.out.println(student);
    }

}
