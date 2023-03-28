package com.dung.manageapartment.entity;

import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.model.UtilityDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "Utility")
public class Utility {
    @ManyToMany(mappedBy = "utilities")
    private Set<Bill> bills;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted = false;


    @Column(name = "name")
    private String name;

    public Utility edit(UtilityDTO dto) {
        if (Objects.nonNull(dto.getName())) {
            this.name = dto.getName();
        }
this.name = dto.getName();
        return this;
    }

    public Utility delete() {
        this.deleted = true;
        return this;
    }
}
