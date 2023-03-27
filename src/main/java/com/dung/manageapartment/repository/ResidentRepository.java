package com.dung.manageapartment.repository;

import com.dung.manageapartment.entity.Apartment;
import com.dung.manageapartment.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Optional<Resident> findByResident_idAndDeletedFalse(Long resident_id, Boolean deleted);
    List<Resident> getByDeleted(Boolean deleted);

//    Optional<Resident> findByIdAndDeletedFalse(Long id, Boolean deleted);
    Optional<Resident> findByNameAndDeleted(String name, Boolean deleted);


}
