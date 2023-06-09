package com.dung.manageapartment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentDTO {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String idNumber;

    private String gender;

    private LocalDate dateOfBirth;

    private Boolean deleted = false;

    private List<ApartmentDTO> apartments;




}
