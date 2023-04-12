package com.dung.manageapartment.dto;

import lombok.Data;

@Data
public class BillUtility2DTO {

    private Long id;

    private Long unitPrice;

    private int quantity;

    private UtilityDTO utilityDTO;

    private Bill2DTO billDTO;
}
