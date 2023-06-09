package com.dung.manageapartment.repository;

import com.dung.manageapartment.model.Resident;
import com.dung.manageapartment.model.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilityRepository extends JpaRepository<Utility, Long> {

    List<Utility> getByDeleted(Boolean deleted);

    Optional<Utility> findByIdAndDeletedFalse(Long id);

    List<Utility> getAllByDeleted(Boolean deleted);
    @Override
    Optional<Utility> findById(Long aLong);



}
