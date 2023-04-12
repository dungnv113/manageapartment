package com.dung.manageapartment.dao.impl;

import com.dung.manageapartment.dao.Bill2Dao;
import com.dung.manageapartment.model.Bill;
import com.dung.manageapartment.model.Bill2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class Bill2DaoImpl implements Bill2Dao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insert(Bill2 bill) {
        entityManager.persist(bill);
    }

    @Override
    public void update(Bill2 bill) {
        entityManager.merge(bill);
    }

    @Override
    public void delete(Bill2 bill) {
        entityManager.remove(bill);
    }

    @Override
    public Bill2 get(Long id) {
        return entityManager.find(Bill2.class, id);
    }

    @Override
    public List<Bill2> search(String findName, int start, int length) {
        String jql = "select b from Bill2 b join b.apartment a where a.name like :aname";
        return entityManager.createQuery(jql, Bill2.class).setParameter("aname", "%" + findName + "%").setFirstResult(start).setMaxResults(length).getResultList();
    }

    @Override
    public List<Bill2> searchByApartmentId(Long apartmentId, int start, int length) {
        String jql = "select b from Bill2 b join b.apartment a where a.id = :apartmentId";
        return entityManager.createQuery(jql, Bill2.class).setParameter("apartmentId", apartmentId).setFirstResult(start).setMaxResults(length).getResultList();
    }
}
