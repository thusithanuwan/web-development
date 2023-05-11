package lk.ijse.dep10;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.dep10.model.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {
    public static void main(String[] args) throws FileNotFoundException {
        Jsonb jsonb = JsonbBuilder.create();
        /*javaObject = fromJson(json, convert type of class object) */
        List<Student> StudentList = jsonb.fromJson(new FileReader("student-list.json"), new ArrayList<Student>().getClass());
        System.out.println(StudentList);
        System.out.println(StudentList.get(1));
    }
}
