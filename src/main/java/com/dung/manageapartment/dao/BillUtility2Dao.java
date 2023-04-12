package com.dung.manageapartment.dao;

import com.dung.manageapartment.model.BillUtility2;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BillUtility2Dao {
    void insert(BillUtility2 billUtility);

    void update(BillUtility2 billUtility);

    void delete(BillUtility2 billUtility);

    BillUtility2 get(Long id);

    List<BillUtility2> search(String findName, int start, int length);

    List<BillUtility2> searchByBill(Long idBill, int start, int length);
}
