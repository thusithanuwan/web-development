package lk.ijse.dep10.pos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDTO {
    //https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-error-sqlstates.html
    private int status;
    private String message;
}
