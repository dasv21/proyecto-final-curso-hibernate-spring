package com.santiago.proyectohibernate.services.dao;

import com.santiago.proyectohibernate.dao.BillingInfoDAOImpl;
import com.santiago.proyectohibernate.entities.BillingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingInfoServiceDAO {
    @Autowired
    private BillingInfoDAOImpl repository;

    public BillingInfo create(BillingInfo billingInfo) {
        return repository.create(billingInfo);
    }

    public BillingInfo update(BillingInfo billingInfo) {
        return repository.update(billingInfo);
    }

    public List<BillingInfo> findAll() {
        return repository.findAll();
    }

    public BillingInfo findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
