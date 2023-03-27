package com.dung.manageapartment.entity;

import com.dung.manageapartment.model.ResidentDTO;
import lombok.Data;
import org.hibernate.sql.Delete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "resident")
public class Resident {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String idNumber;

    private String gender;

    private LocalDate dateOfBirth;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

//    public Resident update(ResidentDTO dto) {
//        this.name = dto.getName();
//        this.apartment = dto
//
//    }

    // constructors, getters, setters


}
