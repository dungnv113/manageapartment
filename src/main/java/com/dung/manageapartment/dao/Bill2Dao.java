package com.dung.manageapartment.dao;

import com.dung.manageapartment.model.Bill2;

import java.util.List;

public interface Bill2Dao {
    void insert(Bill2 bill);

    void update(Bill2 bill);

    void delete(Bill2 bill);

    Bill2 get(Long id);

    List<Bill2> search(String findName, int start, int length);

    List<Bill2> searchByApartmentId(Long apartmentId, int start, int length);
}
