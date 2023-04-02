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
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Resident resident;


    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name ="month")
    private Date month;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BillStatus status;
    // Constructors, Getters, Setters

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_utility", joinColumns = @JoinColumn(name = "bill_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "utility_id", referencedColumnName = "id"))
    private List<Utility> utilities;
}
