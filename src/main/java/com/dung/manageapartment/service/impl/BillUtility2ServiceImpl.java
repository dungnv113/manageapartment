//package com.dung.manageapartment.service.impl;
//
//import com.dung.manageapartment.dao.BillUtility2Dao;
//import com.dung.manageapartment.dto.BillUtility2DTO;
//import com.dung.manageapartment.dto.UtilityDTO;
//import com.dung.manageapartment.model.Bill2;
//import com.dung.manageapartment.model.BillUtility2;
//import com.dung.manageapartment.model.Utility;
//import com.dung.manageapartment.service.BillUtility2Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional
//@Service
//public class BillUtility2ServiceImpl implements BillUtility2Service {
//    @Autowired
//    private BillUtility2Dao billUtility2Dao;
//
//    @Override
//    public void insert(BillUtility2DTO billUtility2DTO) {
//
//        BillUtility2 billUtility = new BillUtility2();
//        billUtility.setUnitPrice(billUtility2DTO.getUnitPrice());
//        billUtility.setQuantity(billUtility2DTO.getQuantity());
//
//        Bill2 bill = new Bill2();
//        bill.setId(billUtility2DTO.getBillDTO().getId());
//        billUtility.setBill(bill);
//
//        Utility utility = new Utility();
//        utility.setId(billUtility2DTO.getUtilityDTO().getId());
//        billUtility.setUtility(utility);
//
//        billUtility2Dao.insert(billUtility);
//    }
//
//    @Override
//    public void update(BillUtility2DTO billUtilityDTO) {
//
//        BillUtility2 billUtility2 = billUtility2Dao.get(billUtilityDTO.getId());
//
//        if(billUtility2 != null) {
//            billUtility2.setId(billUtilityDTO.getId());
//            billUtility2.setUnitPrice(billUtilityDTO.getUnitPrice());
//            billUtility2.setQuantity(billUtilityDTO.getQuantity());
//
//            Bill2 bill = new Bill2();
//            bill.setId(billUtilityDTO.getBillDTO().getId());
//            billUtility2.setBill(bill);
//
//            Utility utility = new Utility();
//            utility.setId(billUtilityDTO.getUtilityDTO().getId());
//            billUtility2.setUtility(utility);
//
//            billUtility2Dao.update(billUtility2);
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        BillUtility2 billUtility2 = billUtility2Dao.get(id);
//        if(billUtility2 != null) {
//            billUtility2Dao.delete(billUtility2);
//        }
//    }
//
//    @Override
//    public BillUtility2DTO get(Long id) {
//        BillUtility2 billUtility2 = billUtility2Dao.get(id);
//        return convertDTO(billUtility2);
//    }
//
//    private BillUtility2DTO convertDTO(BillUtility2 billUtility2) {
//
//        BillUtility2DTO billUtility2DTO = new BillUtility2DTO();
//
//        billUtility2DTO.setId(billUtility2.getId());
//        billUtility2DTO.setUnitPrice(billUtility2.getUnitPrice());
//        billUtility2DTO.setQuantity(billUtility2.getQuantity());
//
//        UtilityDTO utilityDTO = new UtilityDTO();
//        utilityDTO.setId(billUtility2.getUtility().getId());
//        utilityDTO.setName(billUtility2.getUtility().getName());
//        utilityDTO.setUnitPrice(billUtility2.getUtility().getUnitPrice());
//
//        billUtility2DTO.setUtilityDTO(utilityDTO);
//
//        return billUtility2DTO;
//    }
//
//    @Override
//    public List<BillUtility2DTO> search(String findName, int start, int length) {
//
//        List<BillUtility2> billUtilities = billUtility2Dao.search(findName, start, length);
//
//        List<BillUtility2DTO> billUtilityDTOs = new ArrayList<BillUtility2DTO>();
//
//        for(BillUtility2 billUtility2 : billUtilities) {
//            billUtilityDTOs.add(convertDTO(billUtility2));
//        }
//        return billUtilityDTOs;
//    }
//
//    @Override
//    public List<BillUtility2DTO> searchByBill(Long billId, int start, int length) {
//        List<BillUtility2> billUtilities = billUtility2Dao.searchByBill(billId, start, length);
//
//        List<BillUtility2DTO> billUtilityDTOs = new ArrayList<BillUtility2DTO>();
//
//        for (BillUtility2 billUtility2 : billUtilities) {
//            billUtilityDTOs.add(convertDTO(billUtility2));
//        }
//
//        return billUtilityDTOs;
//    }
//}
