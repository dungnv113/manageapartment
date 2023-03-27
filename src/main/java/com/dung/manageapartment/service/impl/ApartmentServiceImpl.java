package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.repository.ApartmentRepository;
import com.dung.manageapartment.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper mapper;

    @Override
    public List<ApartmentDTO> getAll() {
        return apartmentRepository.getByDeleted(false).stream().map(apartment -> mapper.map(apartment, ApartmentDTO.class)).toList();
    }

    @Override
    public String add(ApartmentDTO apartmentDTO) {
        apartmentRepository.save(mapper.map(apartmentDTO, Apartment.class));
        return "redirect:/admin/apartment";
    }

    @Override
    public ApartmentDTO getById(Long id) {
        Optional<Apartment> getId = apartmentRepository.findByIdAndDeletedFalse(id);
//        if (getId == null) {
//            return null;
//        }
        return mapper.map(getId.get(), ApartmentDTO.class);
    }

    @Override
    public String edit(ApartmentDTO apartmentDTO) {
        ApartmentDTO getById = getById(apartmentDTO.getId());
            if (getById == null) {
                return "/admin/editApartment";
            }
            apartmentRepository.save(mapper.map(getById, Apartment.class).edit(apartmentDTO));
            return "redirect:/admin/apartment";
    }

    @Override
    @Transactional
    public String delete(Long id) {
        ApartmentDTO getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            apartmentRepository.save(mapper.map(getId, Apartment.class).delete());
        }
        return "redirect:/admin/apartment";
    }

//    public Apartment getId(Long id, Model model) {
//        Optional<Apartment> findById = apartmentRepository.findByIdAndDeleted(id, false);
//        if (findById.isEmpty()) {
//            model.addAttribute("err", "k ton tai");
//            return null;
//        }
//        return findById.get();
//    }


}
