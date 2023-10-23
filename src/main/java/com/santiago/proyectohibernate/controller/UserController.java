package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.projection.UserProjection;
import com.santiago.proyectohibernate.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @ResponseBody
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("projection")
    @ResponseBody
    public List<UserProjection> findAllUserProjection() {
        return service.findAllUserProjection();
    }

    @GetMapping("active")
    @ResponseBody
    public List<User> findActive() {
        return service.findActive();
    }

    @GetMapping("inactive")
    @ResponseBody
    public List<User> findInactive() {
        return service.findInactive();
    }

    @GetMapping("{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseBody
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping
    @ResponseBody
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteByID(id);
    }
}
