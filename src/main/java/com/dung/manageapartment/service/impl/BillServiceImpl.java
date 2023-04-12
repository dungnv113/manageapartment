package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.model.Bill;
import com.dung.manageapartment.model.Utility;
import com.dung.manageapartment.repository.BillRepository;
import com.dung.manageapartment.repository.UtilityRepository;
import com.dung.manageapartment.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    private final UtilityRepository utilityRepository;
    @Override
    public List<Bill> getAll() {
        return billRepository.getByDeleted(false).stream().toList();
    }

    @Override
    public String addBill(Bill bill) {
        billRepository.save(bill);
        return "redirect:/admin/bill";
    }

    @Override
    public Bill getById(Long id) {
        Optional<Bill> getId = billRepository.findById(id);
        return getId.get();
    }

    @Override
    public String edit(Bill bill) {
        Bill getId = getById(bill.getId());
        if(getId == null) {
            return "/admin/editBill";
        }
        billRepository.save(getId);
        return "redirect:/admin/bill";
    }

    @Override
    public String delete(Long id) {
        Bill getId = getById(id);
        if(getId != null){
            getId.setDeleted(true);
            billRepository.save(getId).delete();
        }
        return "redirect:/admin/bill";
    }

    @Override
    public List<Utility> getUtility() {
        return utilityRepository.getByDeleted(false).stream().toList();
    }
}
