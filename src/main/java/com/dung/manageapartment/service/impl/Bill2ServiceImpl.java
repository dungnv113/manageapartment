package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.dao.Bill2Dao;
import com.dung.manageapartment.dto.ApartmentDTO;
import com.dung.manageapartment.dto.Bill2DTO;
import com.dung.manageapartment.model.Apartment;
import com.dung.manageapartment.model.Bill2;
import com.dung.manageapartment.service.Bill2Service;
import com.dung.manageapartment.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class Bill2ServiceImpl implements Bill2Service {
    @Autowired
    private Bill2Dao billDao;

    @Override
    public void insert(Bill2DTO billDTO) {

        Bill2 bill = new Bill2();

        bill.setDate(new Date());
        bill.setApartment(new Apartment(billDTO.getApartmentDTO().getId()));
        bill.setStatus(billDTO.getStatus());
        bill.setPay(billDTO.getPay());

        billDao.insert(bill);
        billDTO.setId(bill.getId());
    }

    @Override
    public void update(Bill2DTO billDTO) {
        Bill2 bill = billDao.get(billDTO.getId());

        if(bill != null) {

            // them dong 46
            bill.setDate(new Date());

            bill.setPriceTotal(billDTO.getPriceTotal());
            bill.setStatus(billDTO.getStatus());
            bill.setPay(billDTO.getPay());

            //them dong 54
            bill.setApartment(new Apartment(billDTO.getApartmentDTO().getId()));

            billDao.update(bill);
        }
    }

    @Override
    public void delete(Long id) {
        Bill2 bill = billDao.get(id);

        if(bill != null) {
            billDao.delete(bill);
        }
    }

    @Override
    public Bill2DTO get(Long id) {
        Bill2 bill = billDao.get(id);
        return convertDTO(bill);
    }

    private Bill2DTO convertDTO(Bill2 bill) {
        Bill2DTO billDTO = new Bill2DTO();

        billDTO.setId(bill.getId());
//        billDTO.setDate(DateTimeUtils.formatDate(bill.getDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
        billDTO.setPriceTotal(bill.getPriceTotal());
        // them dong 79
        billDTO.setStatus(bill.getStatus());

        billDTO.setPay(bill.getPay());

        ApartmentDTO apartmentDTO = new ApartmentDTO();
        apartmentDTO.setId(bill.getApartment().getId());
        apartmentDTO.setName(bill.getApartment().getName());

        billDTO.setApartmentDTO(apartmentDTO);
        return billDTO;
    }

    @Override
    public List<Bill2DTO> search(String findName, int start, int length) {

        List<Bill2> bills = billDao.search(findName, start, length);

        List<Bill2DTO> billDTOs = new ArrayList<Bill2DTO>();

        for(Bill2 bill : bills) {
            billDTOs.add(convertDTO(bill));
        }
        return billDTOs;
    }

    @Override
    public List<Bill2DTO> searchByApartmentId(Long apartmentId, int start, int length) {

        List<Bill2> bills = billDao.searchByApartmentId(apartmentId, start, length);

        List<Bill2DTO> billDTOs = new ArrayList<Bill2DTO>();

        if(bills.isEmpty()) {
            return null;
        } else {
            for(Bill2 bill : bills) {
                billDTOs.add(convertDTO(bill));
            }
        }
        return billDTOs;
    }
}
