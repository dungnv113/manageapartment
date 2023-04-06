package com.dung.manageapartment.entity;

import com.dung.manageapartment.constant.BillStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id",insertable = false, updatable = false)
    private Apartment apartment;

    @Column(name = "apartment_id")
    private Long apartment_id;

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

    public Bill delete() {
        this.deleted = true;
        return this;
    }
}
