package com.dung.manageapartment.dao.impl;

import com.dung.manageapartment.dao.BillUtility2Dao;
import com.dung.manageapartment.model.BillUtility2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class BillUtility2DaoImpl implements BillUtility2Dao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insert(BillUtility2 billUtility) {
        entityManager.persist(billUtility);
    }

    @Override
    public void update(BillUtility2 billUtility) {
        entityManager.merge(billUtility);
    }

    @Override
    public void delete(BillUtility2 billUtility) {
        entityManager.remove(billUtility);
    }

    @Override
    public BillUtility2 get(Long id) {
        return entityManager.find(BillUtility2.class, id);
    }

    @Override
    public List<BillUtility2> search(String findName, int start, int length) {

        String jql = "SELECT bu FROM BillUtility2 bu JOIN bu.utility u JOIN bu.bill b WHERE u.name LIKE :uname";

        return entityManager.createQuery(jql, BillUtility2.class).setParameter("uname", "%" + findName + "%").setFirstResult(start)
                .setMaxResults(length).getResultList();
    }

    @Override
    public List<BillUtility2> searchByBill(Long idBill, int start, int length) {

        String jql = "SELECT bu FROM BillUtility2 bu JOIN bu.utility u JOIN bu.bill b WHERE b.id = :billId";
        return entityManager.createQuery(jql, BillUtility2.class).setParameter("billId", idBill).setFirstResult(start)
                .setMaxResults(length).getResultList();
    }
}
