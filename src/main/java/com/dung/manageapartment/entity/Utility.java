package com.dung.manageapartment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Utility")
public class Utility {
    @ManyToMany(mappedBy = "utilities")
    private Set<Bill> bills;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utility_id")
    private Long id;




    @Column(name = "utility_name")
    private String name;


}
