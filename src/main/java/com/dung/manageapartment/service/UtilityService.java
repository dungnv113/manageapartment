package com.dung.manageapartment.service;

import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.model.UtilityDTO;

import java.util.List;

public interface UtilityService {

    List<UtilityDTO>getAll();

    String add(UtilityDTO utility);


    UtilityDTO getById(Long id);

    String edit(UtilityDTO utilityDTO);

    String delete(Long id);
}
