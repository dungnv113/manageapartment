package com.dung.manageapartment.service;

import com.dung.manageapartment.model.ResidentDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface ResidentService {

    List<ResidentDTO> getAll();

    String add(ResidentDTO rsidentDTO, Model model);

    String edit(ResidentDTO residentDTO, Model model);


    ResidentDTO getById(Long id);



}
