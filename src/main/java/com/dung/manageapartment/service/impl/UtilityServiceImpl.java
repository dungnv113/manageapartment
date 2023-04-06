package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.entity.Utility;
import com.dung.manageapartment.model.UtilityDTO;
import com.dung.manageapartment.repository.UtilityRepository;
import com.dung.manageapartment.service.UtilityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilityServiceImpl implements UtilityService {
    private final UtilityRepository utilityRepository;

    private final ModelMapper mapper;
    @Override
    public List<Utility> getAll() {
        return utilityRepository.getByDeleted(false).stream().toList();
    }

    //
    @Override
    public String add(Utility utility) {
        utilityRepository.save(utility);
        return "redirect:/admin/utility";
    }

    @Override
    public Utility getById(Long id) {
        Optional<Utility> getId = utilityRepository.findByIdAndDeletedFalse(id);
    return getId.get();
    }

    @Override
    public String edit(Utility utilityDTO) {
        Utility getById = getById(utilityDTO.getId());
        if (getById == null) {
            return "/admin/editUtility";
        }
        utilityRepository.save(getById);
        return "redirect:/admin/utility";
    }

    @Override
    public String delete(Long id) {
        Utility getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            utilityRepository.save(getId);
        }
        return "redirect:/admin/utility";
    }

}
