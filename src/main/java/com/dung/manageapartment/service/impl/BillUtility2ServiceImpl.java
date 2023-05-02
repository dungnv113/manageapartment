package com.dung.manageapartment.service.impl;

import com.dung.manageapartment.dto.BillUtility2DTO;
import com.dung.manageapartment.repository.BillUtility2Repo;
import com.dung.manageapartment.service.BillUtility2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BillUtility2ServiceImpl implements BillUtility2Service {

    @Override
    public Long getTotalPrice(Long x) {
        return billUtility2Repo.getTotalPrice(x);
    }

    @Autowired
    private BillUtility2Repo billUtility2Repo;

    @Override
    public void delete(Long id) {

    }

    @Override
    public BillUtility2DTO get(Long id) {
        return null;
    }

    @Override
    public List<BillUtility2DTO> search(String findName, int start, int length) {
        return null;
    }

    @Override
    public List<BillUtility2DTO> searchByBill(Long billId, int start, int length) {
        return null;
    }


}
