package com.dung.manageapartment.service;

import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.model.ResidentDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface ResidentService {

    List<Resident> getAll();

    String add(Resident resident, Model model);

    String edit(Resident resident);


    Resident getById(Long id);


    String delete(Long id);

}
;
