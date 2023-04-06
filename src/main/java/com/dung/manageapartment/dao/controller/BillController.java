package com.dung.manageapartment.dao.controller;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.entity.Bill;
import com.dung.manageapartment.entity.Utility;
import com.dung.manageapartment.service.ApartmentService;
import com.dung.manageapartment.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/bill")
@RequiredArgsConstructor
public class BillController {
    @Autowired
    private final BillService billService;

    @Autowired
    private final ApartmentService apartmentService;
    //view
    @GetMapping()
    public String listBill(Model model) {
        model.addAttribute("bills", billService.getAll());
        model.addAttribute("utilities", billService.getUtility());
        model.addAttribute("apartments", apartmentService.getAll());
        return "/admin/viewBill";
    }
    //add new
    @GetMapping("/add")
    public String addBill(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("utilities", billService.getUtility());
        model.addAttribute("apartments", apartmentService.getAll());
        return "/admin/addBill";
    }

    //tao bill
    //set can ho vao bill
    //foreach gtri trong utility
    @PostMapping("/add")
    public String addBill(@Valid @ModelAttribute("bill") Bill bill, BindingResult result, Model model,
                          @RequestParam("utility") String numbersStr) {
        List<Integer> numbers = Arrays.stream(numbersStr.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return result.hasErrors() ? "/admin/addBill" : billService.addBill(bill);
    }

    @GetMapping("/edit/{id}")
    public String editBill(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bill", billService.getById(id));
        return "/admin/editBill";
    }

    @PostMapping("/edit")
    public String editBill(@Valid @ModelAttribute("bill") Bill bill, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/Apartment" : billService.edit(bill);
    }
    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable("id") Long id, Model model){
        return billService.delete(id);
    }
}
