package com.dung.manageapartment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bill_utility2")
//@Data
@Getter
@Setter
public class BillUtility2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_price")
    private long unitPrice;

    @Column(name = "quantity")
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "utility_id")
    private Utility utility;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill2 bill;
}