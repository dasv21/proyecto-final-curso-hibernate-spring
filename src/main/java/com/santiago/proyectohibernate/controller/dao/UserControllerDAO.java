package com.santiago.proyectohibernate.controller.dao;

import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.services.dao.UserServiceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dao")
@RequiredArgsConstructor
public class UserControllerDAO {

    @Autowired
    UserServiceDAO service;

    @GetMapping("user")
    @ResponseBody
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("user/activos")
    @ResponseBody
    public List<User> findActivos() {
        return service.findActivos();
    }

    @GetMapping("user/inactivos")
    @ResponseBody
    public List<User> findInactivos() {
        return service.findInactivos();
    }

    @PostMapping("user")
    @ResponseBody
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("user")
    @ResponseBody
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("user/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}
