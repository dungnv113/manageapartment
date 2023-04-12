package com.dung.manageapartment.repository;

import com.dung.manageapartment.model.Bill2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Bill2Repo extends JpaRepository<Bill2, Long> {
    @Query("select b from Bill2 b join b.apartment a where a.id = :apartmentId")
    List<Bill2> search_apartID   (@Param("apartmentId") Long x);
}
