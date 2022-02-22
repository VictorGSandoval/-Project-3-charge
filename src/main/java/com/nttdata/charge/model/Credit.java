package com.nttdata.charge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "charge-credit")
public class Credit {

    @Id
    private String id;
    private String codeCredit; // se conectará con el ms account
    private String codeCharge;
    private Float amount;
    private Boolean status;

}
