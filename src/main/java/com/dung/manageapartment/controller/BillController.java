package com.dung.manageapartment.controller;

import com.dung.manageapartment.model.Bill;
import com.dung.manageapartment.model.BillUtility;
import com.dung.manageapartment.model.Utility;
import com.dung.manageapartment.repository.BillRepository;
import com.dung.manageapartment.repository.BillUtilityRepository;
import com.dung.manageapartment.repository.UtilityRepository;
import com.dung.manageapartment.service.ApartmentService;
import com.dung.manageapartment.service.BillService;
import com.dung.manageapartment.service.impl.BillUtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/bill")
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;

    private final ApartmentService apartmentService;
    private final BillUtilityService billUtilityService;

    private final BillRepository billRepository;

    private final UtilityRepository utilityRepository;

    private final BillUtilityRepository billUtilityRepository;

    //view
//    @GetMapping()
//    public String listBill(Model model) {
//        model.addAttribute("bills", billService.getAll());
//        model.addAttribute("utilities", billService.getUtility());
//        model.addAttribute("apartments", apartmentService.getAll());
//        model.addAttribute("all",billUtilityService.getBillUtility());
//        return "/admin/viewbill";
//    }

//    @GetMapping("/detail")
//    public String billDetail(Model model) {
//        List<Object[]> results = billRepository.findAllBillsWithUtilities();
//        model.addAttribute("all", results);
//        return "/admin/billdetail";
//    }
    //add new


    @GetMapping("/add2")
    public String addBill(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("utilities", billService.getUtility());
        model.addAttribute("billutilities", billUtilityService.getBillUtility());
        model.addAttribute("apartments", apartmentService.getAll());
        return "/admin/addbill";
    }

    //tao bill
    //set can ho vao bill
    //foreach gtri trong utility
    @PostMapping("/add2")
    public String addBill( @Valid @ModelAttribute("bill") Bill bill,BindingResult result, Model model,
                          @RequestParam("number") int number,
                          @RequestParam("apartmentId") Long apartmentId,
                          @RequestParam( "utilityId") Long utilityId
                          ) {
        Bill bill1 = new Bill();
        Utility utility = utilityRepository.findById(utilityId).orElseThrow(() -> new IllegalArgumentException("Invalid utility id"));
        billRepository.save(bill1);
        utilityRepository.save(utility);
        // Tạo đối tượng BillUtility để lưu thông tin vào bảng trung gian
        BillUtility billUtility = new BillUtility();
        billUtility.setBill(bill1);
        billUtility.setUtility(utility);
        billUtilityRepository.save(billUtility);

        return "/admin/addbill" ;
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Bill bill, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "/admin/addbill";
        }
        billRepository.save(bill);

        return "redirect/viewbill";
    }
    @GetMapping("/edit/{id}")
    public String editBill(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bill", billService.getById(id));
        return "/admin/editbill";
    }


    @PostMapping("/edit")
    public String editBill(@Valid @ModelAttribute("bill") Bill bill, BindingResult result, Model model) {
        return result.hasErrors() ? "edit/bill" : billService.edit(bill);
    }

    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable("id") Long id, Model model) {
        return billService.delete(id);
    }
}
