package com.dung.manageapartment.dto;

import com.dung.manageapartment.model.Bill;
import com.dung.manageapartment.model.Utility;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class BillUtilityDTO {

    private Long id;

    private BillDTO bill;

    private UtilityDTO utility;

    private int number;
    // Other fields and methods
}
