package com.dung.manageapartment.model;

import com.dung.manageapartment.constant.BillStatus;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id",insertable = false, updatable = false)
    private Apartment apartment;

//    @Column(name = "apartment_id")
//    private Long apartmentId;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name ="month")
    private Date month;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BillStatus status;
    // Constructors, Getters, Setters
    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted = false;

//    public Bill(int number, Long apartmentid) {
//        this.number = number;
//        this.apartmentId = apartmentid;
//    }


    public Bill delete() {
        this.deleted = true; //?
        return this;
    }
    @Column(name ="number")
    private int number;

    }

