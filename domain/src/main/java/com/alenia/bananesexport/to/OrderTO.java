package com.alenia.bananesexport.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTO {
    @NotNull(message = "recipient should not be null")
    private RecipientTO recipient;
    @NotNull(message = "DeliveryDate should not be null")
    private LocalDate deliveryDate;
    @NotNull(message = "Quantity should not be null")
    private Double quantity;
    @NotNull(message = "Price should not be null")
    private Double price;
}
