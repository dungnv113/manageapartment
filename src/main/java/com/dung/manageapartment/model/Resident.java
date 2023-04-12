package com.dung.manageapartment.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

    private String gender;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;

    private String frontIdCard;

    private String backIdCard;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted = false;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

//    public Resident update(ResidentDTO dto) {
//        this.name = dto.getName();
//        this.apartment = dto
//
////    }
//public Resident edit(ResidentDTO dto) {
//    if (Objects.nonNull(dto.getName())) {
//        this.name = dto.getName();
//    }
//    if (Objects.nonNull(dto.getEmail())) {
//        this.email = dto.getEmail();
//    }
//    if (Objects.nonNull(dto.getPhone())) {
//        this.phone = dto.getPhone();
//    }
//    if (Objects.nonNull(dto.getIdNumber())) {
//        this.idNumber = dto.getIdNumber();
//    }
//    if (Objects.nonNull(dto.getGender())) {
//        this.gender = dto.getGender();
//    }
//    if (Objects.nonNull(dto.getDateOfBirth())) {
//        this.dateOfBirth = dto.getDateOfBirth();
//    }
//    this.name = dto.getName();
//    this.email = dto.getEmail();
//    this.phone = dto.getPhone();
//this.idNumber = dto.getIdNumber();
//this.gender = dto.getGender();
//this.dateOfBirth = dto.getDateOfBirth();
//    return this;
//}
    public Resident delete() {
        this.deleted = true;
        return this;
    }

    // constructors, getters, setters


}
