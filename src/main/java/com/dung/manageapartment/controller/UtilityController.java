package com.dung.manageapartment.controller;


import com.dung.manageapartment.model.ApartmentDTO;
import com.dung.manageapartment.model.UtilityDTO;
import com.dung.manageapartment.service.UtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/utility")
@RequiredArgsConstructor
public class UtilityController {

    private final UtilityService utilityService;

    //show utility
    @GetMapping()
    public String listUtility(Model model){
    model.addAttribute("utility", utilityService.getAll());
    return "/admin/utility";
    }

    //add utility
    @GetMapping("/add")
    public String addUtility(Model model){
        model.addAttribute("utility", new UtilityDTO());
        return "/admin/addUtility";
    }

    @PostMapping("/add")
    public String addUtility(@Valid @ModelAttribute("utility") UtilityDTO dto, BindingResult result, Model model){
        return result.hasErrors() ? "admin/addUtility" : utilityService.add(dto);
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        UtilityDTO getId = utilityService.getById(id);
        if (getId == null) {
            return "/error/notFound";
        }
        model.addAttribute("utility", getId);
        return "admin/editResident";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("utility") UtilityDTO dto, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Apartment" : utilityService.edit(dto);
    }

    @GetMapping("/delete/{id}")
    public String deleteApartment(@PathVariable("id") Long id, Model model){
        return utilityService.delete(id);
    }
}
