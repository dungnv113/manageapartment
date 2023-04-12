package com.dung.manageapartment.dto;


import lombok.Data;

import java.util.Date;


@Data
public class Bill2DTO {

    private Long id;

    private Date date;

    private Long priceTotal;

    private ApartmentDTO apartmentDTO;

    private String status;

    private String pay;
}
