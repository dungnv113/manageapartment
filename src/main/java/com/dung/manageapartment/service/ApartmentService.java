package com.dung.manageapartment.service;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.model.ApartmentDTO;

import java.util.List;

public interface ApartmentService {
    List<Apartment> getAll();

    String add(Apartment apartment);

    Apartment getById(Long id);


    String edit(Apartment apartment);

    String delete(Long id);
}
