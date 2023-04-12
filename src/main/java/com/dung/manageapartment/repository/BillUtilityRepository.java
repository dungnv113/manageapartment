package com.dung.manageapartment.repository;

import com.dung.manageapartment.model.BillUtility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillUtilityRepository extends JpaRepository<BillUtility, Long> {

    List<BillUtility> findAll();
}
