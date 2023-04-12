package com.dung.manageapartment.repository;

import com.dung.manageapartment.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    List<Resident> getAllByDeleted(Boolean deleted);

    Optional<Resident> findByIdAndDeletedFalse(Long id);
    Optional<Resident> findByNameAndDeleted(String name, Boolean deleted);


}
