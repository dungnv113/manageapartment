package com.dung.manageapartment.model;

import com.dung.manageapartment.entity.Apartment;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Data
public class ResidentDTO {
    private Long resident_id;

    private String name;

    private String email;

    private String phone;

    private String idNumber;

    private String gender;

    private LocalDate dateOfBirth;

    private Boolean deleted = false;

    private List<ApartmentDTO> apartments;




}
