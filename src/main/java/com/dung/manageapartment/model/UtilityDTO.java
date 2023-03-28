package com.dung.manageapartment.model;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.entity.Bill;
import com.dung.manageapartment.entity.Utility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilityDTO {

    private Long id;

    private Boolean deleted = false;

    private String name;

    public static UtilityDTO mapper(Utility utility){
        return UtilityDTO.builder()
                .name(utility.getName())
                .build();
    }
}
