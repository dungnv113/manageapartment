package com.dung.manageapartment.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bill_utility2")
@Data
public class BillUtility2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_price")
    private Long unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "utility_id")
    private Utility utility;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill2 bill;
}
