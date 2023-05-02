package com.dung.manageapartment.controller;

import com.dung.manageapartment.model.Apartment;
import com.dung.manageapartment.model.Bill2;
import com.dung.manageapartment.model.BillUtility2;
import com.dung.manageapartment.repository.ApartmentRepository;
import com.dung.manageapartment.repository.Bill2Repo;
import com.dung.manageapartment.repository.BillUtility2Repo;
import com.dung.manageapartment.service.Bill2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/bill")
public class Bill2Controller {
    @Autowired
    Bill2Repo bill2Repo;

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    BillUtility2Repo billUtility2Repo;

    @Autowired
    private Bill2Service bill2Service;

    @GetMapping("/add")
    public String create(Model model) {
        List<Apartment> apartments = apartmentRepository.findAll();
        model.addAttribute("apartments", apartments);

        model.addAttribute("bill", new Bill2());
        return "/admin/addBill2";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Bill2 bill) {
        bill.setDate(new Date());
        bill2Repo.save(bill);
        return "redirect:/admin/bill/viewbill";
    }
    @GetMapping("/viewbill")
    public String listBill2(Model model) {


        model.addAttribute("all", bill2Repo.findAll());
        return "/admin/viewbill";
    }

    @GetMapping("/chi-tiet")
    public String listBill(Model model,
                           @RequestParam(name = "billId", required = false) Long billId
    ) {
        List<BillUtility2> list = billUtility2Repo.search_bIDs(billId);

        model.addAttribute("bill_utilities", list);

        System.out.println(list);
        model.addAttribute("billId", billId);
        return "/admin/viewbill_utility";
    }
}