package com.dung.manageapartment.repository;

import com.dung.manageapartment.model.BillUtility2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface BillUtility2Repo extends JpaRepository<BillUtility2, Long> {
    @Query("SELECT bu FROM BillUtility2 bu JOIN bu.bill b WHERE b.id = :bId")
//    Page<BillUtility2> search_bID(@Param("bId") Long x, Pageable pageable);
    List<BillUtility2> search_bIDs( @Param("bId") Long x);
}
