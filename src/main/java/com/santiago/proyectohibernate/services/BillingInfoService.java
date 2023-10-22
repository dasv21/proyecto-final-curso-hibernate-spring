package com.santiago.proyectohibernate.services;

import com.santiago.proyectohibernate.entities.BillingInfo;
import com.santiago.proyectohibernate.repositories.BillingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingInfoService {
    @Autowired
    private BillingInfoRepository repository;

    public BillingInfo create(BillingInfo billingInfo) {
        return repository.save(billingInfo);
    }

    public BillingInfo update(BillingInfo billingInfo) {
        return repository.save(billingInfo);
    }

    public List<BillingInfo> findAll() {
        return repository.findAll();
    }

    public BillingInfo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteByID(Long id) {
        repository.deleteById(id);
    }
}
