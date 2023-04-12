package com.dung.manageapartment.service;

import com.dung.manageapartment.model.Apartment;

import java.util.List;

public interface ApartmentService {
    List<Apartment> getAll();

    String add(Apartment apartment);

    Apartment getById(Long id);


    String edit(Apartment apartment);

    String delete(Long id);
}
