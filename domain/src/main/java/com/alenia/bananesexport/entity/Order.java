package com.alenia.bananesexport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Recipient recipient;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    @Column(name = "QUANTITY")
    private Double quantity;

    @Column(name = "PRICE")
    private Double price;
}
