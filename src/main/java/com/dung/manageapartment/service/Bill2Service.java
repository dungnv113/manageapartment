package com.dung.manageapartment.service;

import com.dung.manageapartment.dto.Bill2DTO;
import com.dung.manageapartment.dto.BillDTO;

import java.util.List;

public interface Bill2Service {
    void insert(Bill2DTO billDTO);

    void update(Bill2DTO billDTO);

    void delete(Long id);

    Bill2DTO get(Long id);

    List<Bill2DTO> search(String findName, int start, int length);

    List<Bill2DTO> searchByApartmentId(Long apartmentId, int start, int length);
}
