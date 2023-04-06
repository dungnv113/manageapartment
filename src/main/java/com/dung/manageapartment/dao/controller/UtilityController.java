package com.dung.manageapartment.dao.controller;


import com.dung.manageapartment.entity.Utility;
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
    public String listUtility(Model model) {
        model.addAttribute("utility", utilityService.getAll());
        return "/admin/viewUtility";
    }

    //add utility
    @GetMapping("/add")
    public String addUtility(Model model) {
        model.addAttribute("utility", new Utility());
        return "/admin/addUtility";
    }

    @PostMapping("/add")
    public String addUtility(@Valid @ModelAttribute("utility") Utility dto, BindingResult result, Model model) {
        return result.hasErrors() ? "admin/addUtility" : utilityService.add(dto);
    }


    //update utility
    @GetMapping("/edit/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        Utility getId = utilityService.getById(id);
        if (getId == null) {
            return "/error/notFound";
        }
        model.addAttribute("utility", getId);
        return "admin/editUtility";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("utility") Utility dto, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Apartment" : utilityService.edit(dto);
    }


    //delete utility
    @GetMapping("/delete/{id}")
    public String deleteUtility(@PathVariable("id") Long id, Model model) {
        return utilityService.delete(id);
    }
}
