package com.dung.manageapartment.entity;

import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.entity.Utility;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Bills")
public class Bill {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Utility getUtility() {
        return utility;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bill(Long id, Resident resident, Utility utility, BigDecimal amount) {
        this.id = id;
        this.resident = resident;
        this.utility = utility;
        this.amount = amount;
    }

    // Constructors, Getters, Setters
}
