package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.BillingInfo;

import java.util.List;

public interface BillingInfoDAO {

    BillingInfo create(BillingInfo billingInfo);

    BillingInfo update(BillingInfo billingInfo);

    List<BillingInfo> findAll();

    BillingInfo findById(Long id);

    Boolean deleteById(Long id);
}
