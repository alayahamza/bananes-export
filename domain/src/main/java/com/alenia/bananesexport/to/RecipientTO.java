package com.alenia.bananesexport.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientTO {

    @NotNull(message = "Name should not be null")
    private String name;
    @NotNull(message = "Address should not be null")
    private String address;
    @NotNull(message = "ZipCode should not be null")
    private Integer zipCode;
    @NotNull(message = "City should not be null")
    private String city;
    @NotNull(message = "Country should not be null")
    private String country;
}
