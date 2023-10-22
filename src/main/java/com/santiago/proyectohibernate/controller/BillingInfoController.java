package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.BillingInfo;
import com.santiago.proyectohibernate.services.BillingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jpa")
@RequiredArgsConstructor
public class BillingInfoController {

    @Autowired
    BillingInfoService service;

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
        service.deleteByID(id);
    }
}
