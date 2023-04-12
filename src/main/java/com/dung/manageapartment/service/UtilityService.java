package com.dung.manageapartment.service;

import com.dung.manageapartment.model.Utility;

import java.util.List;

public interface UtilityService {

    List<Utility>getAll();

    String add(Utility utility);


    Utility getById(Long id);

    String edit(Utility utilityDTO);

    String delete(Long id);
}
