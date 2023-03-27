package com.dung.manageapartment.model;

import com.dung.manageapartment.entity.Apartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
