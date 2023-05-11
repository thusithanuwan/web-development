package lk.ijse.dep10.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {
    @JsonbProperty("Student_id")
    int id;
//    @JsonbTransient
    String name;

    @JsonbTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
