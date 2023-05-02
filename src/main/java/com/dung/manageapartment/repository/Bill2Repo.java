package com.dung.manageapartment.repository;

import com.dung.manageapartment.model.Bill2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Bill2Repo extends JpaRepository<Bill2, Long> {
    @Query("select b from Bill2 b join b.apartment a where a.id = :apartmentId")
    List<Bill2> search_apartID(@Param("apartmentId") Long x);

    @Transactional
    @Modifying
    @Query("UPDATE Bill2 b SET b.priceTotal = ?1 WHERE b.id = ?2")
    void updateTotalPrice(Long x, Long y);
}