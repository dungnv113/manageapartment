package com.dung.manageapartment.controller;


import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.model.ResidentDTO;
import com.dung.manageapartment.service.ApartmentService;
import com.dung.manageapartment.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/resident")
@RequiredArgsConstructor
public class ResidentController {
    private final ResidentService residentService;
    private final ApartmentService apartmentService;

    //show resident
    @GetMapping()
    public String listResident(Model model) {
        model.addAttribute("residents", residentService.getAll());
        model.addAttribute("products", apartmentService.getAll());
        return "/admin/viewResident.html";
    }

    //add new resident
    @GetMapping("/add")
    public String addResident(Model model) {
        model.addAttribute("resident", new ResidentDTO());
        model.addAttribute("listAparments", apartmentService.getAll());
        return "admin/addResident";
    }

    @PostMapping("/add")
    public String addResident(@Valid @ModelAttribute("resident") ResidentDTO dto, BindingResult result, Model model) {
        return result.hasErrors() ? "/admin/addApartment" : residentService.add(dto, model);
    }


    //edit resident information
    @GetMapping("/edit/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        ResidentDTO getId = residentService.getById(id);
        if (getId == null) {
            return "/error/notFound";
        }
        model.addAttribute("resident", getId);
        model.addAttribute("listApartment", apartmentService.getAll());
        return "admin/editResident";
    }

    //
    @PostMapping("/edit")
    public String updatePost(@Valid @ModelAttribute("product") ResidentDTO dto, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Resident" : residentService.edit(dto);
    }

    //
//
    //delete resident
    @GetMapping("/delete/{id}")
    public String deleteResident(@PathVariable("id") Long id, Model model) {
        return residentService.delete(id);
    }
}