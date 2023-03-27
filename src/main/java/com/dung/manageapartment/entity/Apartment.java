package com.dung.manageapartment.entity;

import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.model.ApartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
    private Long id;

    private String name;
    private Double area;
    private Integer num_rooms;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted = false;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Resident> residents = new ArrayList<>();

    public Apartment edit(ApartmentDTO dto) {
        if (Objects.nonNull(dto.getArea())) {
            this.area = dto.getArea();
        }
        if (Objects.nonNull(dto.getName())) {
            this.name = dto.getName();
        }
        if (Objects.nonNull(dto.getNum_rooms())) {
            this.num_rooms = dto.getNum_rooms();
        }
        this.name = dto.getName();
        this.area = dto.getArea();
        this.num_rooms = dto.getNum_rooms();

        return this;
    }

    public Apartment delete() {
        this.deleted = true;
        return this;
    }


}
