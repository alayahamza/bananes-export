package com.alenia.bananesexport.to;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private long recipient;
    @NotNull(message = "DeliveryDate should not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;
    @NotNull(message = "Quantity should not be null")
    private Double quantity;
}
