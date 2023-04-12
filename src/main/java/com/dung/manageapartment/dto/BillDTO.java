package com.dung.manageapartment.dto;

import com.dung.manageapartment.constant.BillStatus;
import com.dung.manageapartment.model.Apartment;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class BillDTO {
private String utilityName;
private int number;
}
