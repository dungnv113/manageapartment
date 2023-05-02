package com.dung.manageapartment.service;

import com.dung.manageapartment.dto.Bill2DTO;
import com.dung.manageapartment.dto.BillDTO;
import com.dung.manageapartment.model.*;
import com.dung.manageapartment.repository.Bill2Repo;
import com.dung.manageapartment.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class Bill2Service {
    @Autowired
    private UtilityRepository utilityRepository;
    @Autowired
    private Bill2Repo bill2Repo;


    public void updateTotalPrice(Long x, Long y) {
        bill2Repo.updateTotalPrice(x, y);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Bill2 getBillById(Long billId) {
        return entityManager.find(Bill2.class, billId);
    }


    public Bill2 calculateTotalAmount(Bill2 bill) {
        List<BillUtility2> billUtilities = bill.getBillUtilities() ;
        Long totalAmount = 0L;
        for (BillUtility2 billUtility : billUtilities) {
            Long utilityId = billUtility.getUtility().getId();
            Utility utility = utilityRepository.getOne(utilityId);
            totalAmount += utility.getUnitPrice();
        }
        bill.setPriceTotal(totalAmount);
        return bill;
    }



}