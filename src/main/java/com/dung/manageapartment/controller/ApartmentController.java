package com.dung.manageapartment.controller;

import com.dung.manageapartment.model.Apartment;
import com.dung.manageapartment.service.ApartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/apartment")
@RequiredArgsConstructor
@Api(value=" Management System", description="Operations pertaining to user management in the  Management System")
public class ApartmentController {
    private final ApartmentService apartmentService;

    //show apartment
    @GetMapping()
    @ApiOperation(value="View a list of available apartment", response=String.class)
    public String listApartment(Model model){
        model.addAttribute("apartments",apartmentService.getAll());
        return "/admin/view.html";
    }


    //add mew apartment
    @GetMapping("/add")
    public String addApartment(Model model){
        model.addAttribute("apartment", new Apartment());
        return "admin/addApartment";
    }


    @PostMapping("/add")
    public String addApartment(@Valid @ModelAttribute("apartment") Apartment apartment, BindingResult result, Model model) {
        return result.hasErrors() ? "/admin/addApartment" : apartmentService.add(apartment);
    }


    //edit apartment information
    @GetMapping("/edit/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        Apartment getId = apartmentService.getById(id);
        if (getId == null) {
            return "/error/notFound";
        }
        model.addAttribute("apartment", getId);
        return "admin/editApartment";
    }

    @PostMapping("/edit")
    public String updatePost(@Valid @ModelAttribute("product") Apartment dto, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Apartment" : apartmentService.edit(dto);
    }

    //delete apartment
    @GetMapping("/delete/{id}")
    public String deleteApartment(@PathVariable("id") Long id, Model model){
        return apartmentService.delete(id);
    }
}
