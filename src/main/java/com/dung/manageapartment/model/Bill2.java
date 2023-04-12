package com.dung.manageapartment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill2")
//@Data
@Getter
@Setter
public class Bill2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "price_total")
    private Long priceTotal;


    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "bill")
    private List<BillUtility2> billUtilities;


}
