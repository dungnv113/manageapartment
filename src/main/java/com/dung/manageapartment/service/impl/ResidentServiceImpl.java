package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.model.ResidentDTO;
import com.dung.manageapartment.repository.ResidentRepository;
import com.dung.manageapartment.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {
    ModelMapper mapper;
    ResidentRepository residentRepository;
    @Override
    public List<ResidentDTO> getAll() {
        return residentRepository.getByDeleted(false).stream().map(resident -> mapper.map(resident, ResidentDTO.class)).toList();
    }
    public ResidentDTO getByName(String name) {
        Optional<Resident> findByName = residentRepository.findByNameAndDeleted(name, false);
        return findByName.map(resident -> mapper.map(resident, ResidentDTO.class)).orElse(null);
    }
    @Override
    public String add(ResidentDTO residentDTO, Model model) {
        ResidentDTO getByName = getByName(residentDTO.getName());
        if (getByName != null) {
            model.addAttribute("err", "ten da ton tai");
            return "/admin/addProduct";
        }
       residentRepository.save(mapper.map(residentDTO, Resident.class));
        return "redirect:/admin/product";
    }

    public Resident getId(Long id, Model model) {
        Optional<Resident> findById = residentRepository.findByResident_idAndDeletedFalse(id, false);
        if (findById.isEmpty()) {
            model.addAttribute("err", "k ton tai");
            return null;
        }
        return findById.get();
    }

//    @Override
//    public ResidentDTO getByid(Long id) {
//        ResidentDTO getId = getId(id);
//        return  mapper.map(getId, ResidentDTO.class);
//    }




}
