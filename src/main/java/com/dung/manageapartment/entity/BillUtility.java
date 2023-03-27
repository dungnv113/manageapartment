package com.dung.manageapartment.entity;

import javax.persistence.*;

@Entity
@Table(name = "bill_utility")
public class BillUtility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "utility_id")
    private Utility utility;

    // Other fields and methods
}
