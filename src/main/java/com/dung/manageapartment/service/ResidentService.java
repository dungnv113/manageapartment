package com.dung.manageapartment.service;

import com.dung.manageapartment.model.ResidentDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface ResidentService {

    List<ResidentDTO> getAll();

    String add(ResidentDTO productDTO, Model model);


    ResidentDTO getByid(Long id);



}
