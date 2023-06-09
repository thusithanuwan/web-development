package lk.ijse.dep10.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO { /* ! DTO - Data Transfer Object*/
    private Integer id;  // Why we get Integer
    private String name;
    private  String address;
    private  String contact;
}
