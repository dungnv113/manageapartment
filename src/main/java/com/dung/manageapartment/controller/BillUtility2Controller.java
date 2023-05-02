package com.dung.manageapartment.controller;

import com.dung.manageapartment.model.*;
import com.dung.manageapartment.repository.Bill2Repo;
import com.dung.manageapartment.repository.BillUtility2Repo;
import com.dung.manageapartment.repository.UtilityRepository;
import com.dung.manageapartment.service.Bill2Service;
import com.dung.manageapartment.service.BillUtility2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin/bill-utility")
public class BillUtility2Controller {
    @Autowired
    Bill2Repo bill2Repo;

    @Autowired
    BillUtility2Repo billUtility2Repo;

    @Autowired
    BillUtility2Service billUtility2Service;
    @Autowired
    UtilityRepository utilityRepository;

    @Autowired
    private Bill2Service bill2Service;

    @GetMapping("/add")
    public String create(Model model) {
        List<Bill2> bills = bill2Repo.findAll();
        model.addAttribute("bills", bills);

        List<Utility> utilities = utilityRepository.getAllByDeleted(false);
        model.addAttribute("utilities", utilities);

        return "/admin/addbill_utility2";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute BillUtility2 billUtility2) {


        Optional<Utility> utility = utilityRepository.findById(billUtility2.getUtility().getId());


        long unitPrice = billUtility2.getQuantity() * utility.get().getUnitPrice();
        billUtility2.setUnitPrice(unitPrice);
        billUtility2Repo.save(billUtility2);
        Long priceTotal =billUtility2Service.getTotalPrice(billUtility2.getBill().getId());
        bill2Service.updateTotalPrice(priceTotal,billUtility2.getBill().getId());


        return "redirect:/admin/bill/viewbill";
    }


    @GetMapping("/viewbill-utility")
    public String listBill(Model model) {
        model.addAttribute("all", billUtility2Repo.findAll());
        return "/admin/viewbill_utility2";
    }
}