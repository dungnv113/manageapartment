//package com.dung.manageapartment.repository;
//
//import com.dung.manageapartment.model.Bill;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface BillRepository extends JpaRepository<Bill, Long> {
//
//    @Query(value = "SELECT b.id, u.name, u.unitPrice, b.number, u.unitPrice * b.number AS total "
//            + "FROM Bill b "
//            + "JOIN BillUtility bu ON b.id = bu.bill.id "
//            + "JOIN Utility u ON u.id = bu.utility.id")
//    List<Object[]> findAllBillsWithUtilities();
//
//
//    List<Bill> getByDeleted(Boolean deleted);
//    Optional<Bill> findById(Long id);
//
//
//}
//
