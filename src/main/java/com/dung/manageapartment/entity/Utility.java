package com.dung.manageapartment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "Utility")
public class Utility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="unit_price")
    private Long unitPrice;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted = false;


    @Column(name = "name")
    private String name;

    public Utility edit(Utility dto) {
        if (Objects.nonNull(dto.getName())) {
            this.name = dto.getName();
        }
        if (Objects.nonNull(dto.getUnitPrice())) {
            this.unitPrice = dto.getUnitPrice();
        }
this.name = dto.getName();
        this.unitPrice =dto.getUnitPrice();
        return this;
    }

    public Utility delete() {
        this.deleted = true;
        return this;
    }
}
