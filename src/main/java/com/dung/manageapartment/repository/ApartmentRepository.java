package com.dung.manageapartment.repository;

import com.dung.manageapartment.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> getByDeleted(Boolean deleted);

    Optional<Apartment> findByIdAndDeletedFalse(Long id);



}
