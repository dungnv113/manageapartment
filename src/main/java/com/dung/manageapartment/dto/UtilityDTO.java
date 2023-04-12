package com.dung.manageapartment.dto;

import com.dung.manageapartment.model.Utility;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class UtilityDTO {

    private Long id;

    private Boolean deleted = false;

    private String name;
    private Long unitPrice;

//    public static UtilityDTO mapper(Utility utility){
//        return UtilityDTO.builder()
//                .name(utility.getName())
//                .build();
//    }
}
