package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.entity.Utility;
import com.dung.manageapartment.model.ApartmentDTO;
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
    public List<UtilityDTO> getAll() {
        return utilityRepository.getByDeleted(false).stream().map(utility -> mapper.map(utility, UtilityDTO.class)).toList();
    }

    //
    @Override
    public String add(UtilityDTO utility) {
        utilityRepository.save(mapper.map(utility, Utility.class));
        return "redirect:/admin/utility";
    }

    @Override
    public UtilityDTO getById(Long id) {
        Optional<Utility> getId = utilityRepository.findByIdAndDeletedFalse(id);
    return mapper.map(getId.get(), UtilityDTO.class);
    }

    @Override
    public String edit(UtilityDTO utilityDTO) {
        UtilityDTO getById = getById(utilityDTO.getId());
        if (getById == null) {
            return "/admin/editUtility";
        }
        utilityRepository.save(mapper.map(getById, Utility.class).edit(utilityDTO));
        return "redirect:/admin/utility";
    }

    @Override
    public String delete(Long id) {
        UtilityDTO getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            utilityRepository.save(mapper.map(getId, Utility.class).delete());
        }
        return "redirect:/admin/utility";
    }

}
