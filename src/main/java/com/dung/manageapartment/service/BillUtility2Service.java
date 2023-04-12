package com.dung.manageapartment.service;

import com.dung.manageapartment.dto.BillUtility2DTO;

import java.util.List;

public interface BillUtility2Service {
    void insert(BillUtility2DTO billUtilityDTO);

    void update(BillUtility2DTO billUtilityDTO);

    void delete(Long id);

    BillUtility2DTO get(Long id);

    List<BillUtility2DTO> search(String findName, int start, int length);

    List<BillUtility2DTO> searchByBill(Long billId, int start, int length);
}
