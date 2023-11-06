package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.BillingInfo;
import com.santiago.proyectohibernate.services.BillingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billingInfo")
@RequiredArgsConstructor
public class BillingInfoController {

    @Autowired
    BillingInfoService billingInfoService;

    @GetMapping
    @ResponseBody
    public List<BillingInfo> findAll() {
        return billingInfoService.findAll();
    }
}
