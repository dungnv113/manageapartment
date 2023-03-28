package com.dung.manageapartment.service;

import com.dung.manageapartment.model.ResidentDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface ResidentService {

    List<ResidentDTO> getAll();

    String add(ResidentDTO residentDTO, Model model);

    String edit(ResidentDTO residentDTO);


    ResidentDTO getById(Long id);


    String delete(Long id);

}
;
