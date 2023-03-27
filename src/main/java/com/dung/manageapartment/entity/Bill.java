package com.dung.manageapartment.entity;

import com.dung.manageapartment.constant.BillStatus;
import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.entity.Utility;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "bill")
public class Bill {
    @ManyToMany
    @JoinTable(
            name = "bill_utility",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "utility_id"))
    private Set<Utility> utilities;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", referencedColumnName = "resident_id")
    private Resident resident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utility_id", referencedColumnName = "utility_id")
    private Utility utility;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name ="month")
    private Date month;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BillStatus status;
    // Constructors, Getters, Setters
}
