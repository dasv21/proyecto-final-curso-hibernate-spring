package com.santiago.proyectohibernate.services;

import com.santiago.proyectohibernate.entities.BillingInfo;
import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.repositories.BillingInfoRepository;
import com.santiago.proyectohibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingInfoService {

    @Autowired
    BillingInfoRepository billingInfoRepository;

    @Autowired
    UserRepository userRepository;

    public User create(BillingInfo billingInfo, Long userId) {
        User user = userRepository.findById(userId).get();
        user.setBillingInfo(billingInfo);
        return userRepository.save(user);
    }

    public User update(BillingInfo billingInfo, Long userId) {
        User user = userRepository.findById(userId).get();
        user.setBillingInfo(billingInfo);
        return userRepository.save(user);
    }

    public List<BillingInfo> findAll() {
        return billingInfoRepository.findAll();
    }
}
