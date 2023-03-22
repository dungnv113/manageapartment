package com.dung.manageapartment.model;

import org.springframework.context.annotation.Primary;

public class ApartmentDTO {
//    apartment_id (Primary Key): mã căn hộ
//    area: diện tích của căn hộ
//    num_rooms: số phòng của căn hộ
    private int apartment_id;
    private Long area;
    private int num_rooms;

    public int getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(int apartment_id) {
        this.apartment_id = apartment_id;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public int getNum_rooms() {
        return num_rooms;
    }

    public void setNum_rooms(int num_rooms) {
        this.num_rooms = num_rooms;
    }
}
