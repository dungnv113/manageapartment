package com.dung.manageapartment.service;

import com.dung.manageapartment.entity.Bill;
import com.dung.manageapartment.entity.Utility;

import java.util.List;

public interface BillService {
    List<Bill> getAll();

    String addBill(Bill bill);

    Bill getById(Long id);

    String edit(Bill bill);

    String delete(Long id);

    List<Utility> getUtility();
}
