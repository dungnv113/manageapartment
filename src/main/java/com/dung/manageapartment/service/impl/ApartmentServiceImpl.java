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

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper mapper;

    @Override
    public List<Apartment> getAll() {
        return apartmentRepository.getByDeleted(false).stream().toList();
    }

    @Override
    public String add(Apartment apartment) {
        apartmentRepository.save(apartment);
        return "redirect:/admin/apartment";
    }

    @Override
    public Apartment getById(Long id) {
        Optional<Apartment> getId = apartmentRepository.findByIdAndDeletedFalse(id);
//        if (getId == null) {
//            return null;
//        }
        return getId.get();
    }

    @Override
    public String edit(Apartment apartment) {
        Apartment getById = getById(apartment.getId());
            if (getById == null) {
                return "/admin/editApartment";
            }
            apartmentRepository.save(getById);
            return "redirect:/admin/apartment";
    }

    @Override
    @Transactional
    public String delete(Long id) {
        Apartment getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            apartmentRepository.save(getId).delete();
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
