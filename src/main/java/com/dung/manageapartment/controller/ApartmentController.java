package com.dung.manageapartment.controller;

import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/apartment")
@RequiredArgsConstructor
public class ApartmentController {
    private final ApartmentService apartmentService;
    @GetMapping()
    public String listApartment(Model model){
        model.addAttribute("apartments",apartmentService.getAll());
        return "/admin/view.html";
    }

    @GetMapping("/add")
    public String addApartment(Model model){
        model.addAttribute("apartment", new ApartmentDTO());
        return "admin/addApartment";
    }

    @PostMapping("/add")
    public String addApartment(@Valid @ModelAttribute("apartment") ApartmentDTO dto, BindingResult result, Model model) {
        return result.hasErrors() ? "/admin/addApartment" : apartmentService.add(dto);
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        ApartmentDTO getId = apartmentService.getById(id);
        if (getId == null) {
            return "/error/notFound";
        }
        model.addAttribute("apartment", getId);
        return "admin/editApartment";
    }

    @PostMapping("/edit")
    public String updatePost(@Valid @ModelAttribute("product") ApartmentDTO dto, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Apartment" : apartmentService.edit(dto);
    }

    @GetMapping("/delete/{id}")
    public String deleteApartment(@PathVariable("id") Long id, Model model){
        return apartmentService.delete(id);
    }
}
