package com.dung.manageapartment.service;

import com.dung.manageapartment.entity.Utility;
import com.dung.manageapartment.model.UtilityDTO;

import java.util.List;

public interface UtilityService {

    List<Utility>getAll();

    String add(Utility utility);


    Utility getById(Long id);

    String edit(Utility utilityDTO);

    String delete(Long id);
}
