package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.entity.Resident;
import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.model.ResidentDTO;
import com.dung.manageapartment.repository.ResidentRepository;
import com.dung.manageapartment.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ModelMapper mapper;
    @Override
    public List<ResidentDTO> getAll() {
        return residentRepository.getAllByDeleted(false).stream().map(category -> mapper.map(category, ResidentDTO.class)).toList();

    }
    public ResidentDTO getByName(String name) {
        Optional<Resident> findByName = residentRepository.findByNameAndDeleted(name, false);
        return findByName.map(product -> mapper.map(product, ResidentDTO.class)).orElse(null);
    }
    @Override
    public String add(ResidentDTO residentDTO, Model model) {
        ResidentDTO getByName = getByName(residentDTO.getName());
        residentRepository.save(mapper.map(residentDTO, Resident.class));
        return "redirect:/admin/resident";
    }

    @Override
    public String edit(ResidentDTO residentDTO) {
        ResidentDTO getById = getById(residentDTO.getId());
        if (getById == null) {
            return "/admin/editProduct";
        }
        residentRepository.save(mapper.map(getById, Resident.class).edit(residentDTO));
        return "redirect:/admin/product";
    }

    @Override
    public ResidentDTO getById(Long id) {
        Optional<Resident> getId = residentRepository.findByIdAndDeletedFalse(id);
        return mapper.map(getId, ResidentDTO.class);
    }

    @Override
    public String delete(Long id) {
        ResidentDTO getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            residentRepository.save(mapper.map(getId, Resident.class).delete());
        }
        return "redirect:/admin/apartment";
    }
//
//    @Override
//    public ResidentDTO getByid(Long id) {
//        return null;
//    }
}
