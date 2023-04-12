package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.model.Resident;
import com.dung.manageapartment.dto.ResidentDTO;
import com.dung.manageapartment.repository.ResidentRepository;
import com.dung.manageapartment.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ModelMapper mapper;
    @Override
    public List<Resident> getAll() {
        return residentRepository.getAllByDeleted(false).stream().toList();

    }
    public ResidentDTO getByName(String name) {
        Optional<Resident> findByName = residentRepository.findByNameAndDeleted(name, false);
        return findByName.map(product -> mapper.map(product, ResidentDTO.class)).orElse(null);
    }
    @Override
    public String add(Resident resident, Model model) {
        residentRepository.save(resident);
        return "redirect:/admin/resident";
    }

    @Override
    public String edit(Resident resident) {
        Resident getById = getById(resident.getId());
        if (getById == null) {
            return "/admin/editProduct";
        }
        residentRepository.save(resident);
        return "redirect:/admin/resident";
    }

    @Override
    public Resident getById(Long id) {
        Optional<Resident> getId = residentRepository.findByIdAndDeletedFalse(id);
        return getId.get();
    }

    @Override
    public String delete(Long id) {
        Resident getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            residentRepository.save(getId).delete();
        }
        return "redirect:/admin/resident";
    }
//
//    @Override
//    public ResidentDTO getByid(Long id) {
//        return null;
//    }
}
