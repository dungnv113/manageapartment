package com.dung.manageapartment.repository;

import com.dung.manageapartment.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> getByDeleted(Boolean deleted);
    Optional<Bill> findById(Long id);
}
