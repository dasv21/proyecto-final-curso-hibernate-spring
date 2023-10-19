package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.BillingInfo;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillingInfoDAOImpl implements BillingInfoDAO {

    @Autowired
    private Session session;

    @Override
    public BillingInfo create(BillingInfo billingInfo) throws PersistenceException {

        try {
            session.beginTransaction();
            session.persist(billingInfo);
            session.getTransaction().commit();
            return billingInfo;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public BillingInfo update(BillingInfo billingInfo) throws PersistenceException {
        try {
            session.beginTransaction();
            session.merge(billingInfo);
            session.getTransaction().commit();
            return billingInfo;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<BillingInfo> findAll() {
        return session.createQuery("from BillingInfo", BillingInfo.class).list();
    }

    @Override
    public BillingInfo findById(Long id) {
        return session.find(BillingInfo.class, id);
    }

    @Override
    public Boolean deleteById(Long id) throws PersistenceException {
        try {
            session.beginTransaction();
            BillingInfo billingInfo = findById(id);
            session.remove(billingInfo);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
