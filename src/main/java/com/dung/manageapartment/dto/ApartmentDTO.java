package com.dung.manageapartment.dto;

import com.dung.manageapartment.model.Apartment;
import lombok.*;

//@Data k để nhưu này
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ApartmentDTO {

    private Long id;
    private Double area;
    private Integer num_rooms;

    private String name;

    private Boolean deleted = false;

    public static ApartmentDTO mapper(Apartment apartment){
        return ApartmentDTO.builder()
                .area(apartment.getArea())
                .num_rooms(apartment.getNum_rooms())
                .name(apartment.getName())
                .build();
    }

}
