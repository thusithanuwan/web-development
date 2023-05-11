package model;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @SerializedName("Customer-id")
    int id;
    String name;
    String address;

    private String privateKey;
}
