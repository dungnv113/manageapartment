package com.dung.manageapartment.service;

import com.dung.manageapartment.model.ApartmentDTO;

import java.util.List;

public interface ApartmentService {
    List<ApartmentDTO> getAll();

    String add(ApartmentDTO apartmentDTO);

    ApartmentDTO getById(Long id);


    String edit(ApartmentDTO apartmentDTO);

    String delete(Long id);
}
