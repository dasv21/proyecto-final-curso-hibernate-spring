package com.santiago.proyectohibernate.controller.dao;

import com.santiago.proyectohibernate.entities.BillingInfo;
import com.santiago.proyectohibernate.services.dao.BillingInfoServiceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dao")
@RequiredArgsConstructor
public class BillingInfoControllerDAO {

    @Autowired
    BillingInfoServiceDAO service;

    @GetMapping("billingInfo")
    @ResponseBody
    public List<BillingInfo> findAll() {
        return service.findAll();
    }

    @GetMapping("billingInfo/{id}")
    @ResponseBody
    public BillingInfo findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("billingInfo")
    @ResponseBody
    public BillingInfo create(@RequestBody BillingInfo billingInfo) {
        return service.create(billingInfo);
    }

    @PutMapping("billingInfo")
    @ResponseBody
    public BillingInfo update(@RequestBody BillingInfo billingInfo) {
        return service.update(billingInfo);
    }

    @DeleteMapping("billingInfo/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
