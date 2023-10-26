package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.BillingInfo;
import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.projection.UserProjection;
import com.santiago.proyectohibernate.services.BillingInfoService;
import com.santiago.proyectohibernate.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BillingInfoService billingInfoService;

    @GetMapping
    @ResponseBody
    public List<UserProjection> findAll() {
        return userService.findAllUserProjection();
    }

    @GetMapping("active")
    @ResponseBody
    public List<User> findActive() {
        return userService.findActive();
    }

    @GetMapping("inactive")
    @ResponseBody
    public List<User> findInactive() {
        return userService.findInactive();
    }

    @GetMapping("{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteByID(id);
    }

    @PostMapping("{id}/billingInfo")
    @ResponseBody
    public User createBillinInfo(@RequestBody BillingInfo billingInfo, @PathVariable Long id) {
        return billingInfoService.create(billingInfo, id);
    }

    @PutMapping("{id}/billingInfo")
    @ResponseBody
    public User updateBillinInfo(@RequestBody BillingInfo billingInfo, @PathVariable Long id) {
        return billingInfoService.update(billingInfo, id);
    }
}
