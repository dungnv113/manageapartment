package com.dung.manageapartment.service;

import com.dung.manageapartment.dto.BillUtility2DTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillUtility2Service {


    Long getTotalPrice(Long x);

    void delete(Long id);

    BillUtility2DTO get(Long id);

    List<BillUtility2DTO> search(String findName, int start, int length);

    List<BillUtility2DTO> searchByBill(Long billId, int start, int length);

}
