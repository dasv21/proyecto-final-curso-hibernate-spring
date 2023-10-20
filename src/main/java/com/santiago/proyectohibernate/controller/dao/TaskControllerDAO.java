package com.santiago.proyectohibernate.controller.dao;

import com.santiago.proyectohibernate.entities.Task;
import com.santiago.proyectohibernate.services.dao.TaskServiceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dao")
@RequiredArgsConstructor
public class TaskControllerDAO {

    @Autowired
    TaskServiceDAO service;

    @GetMapping("task")
    @ResponseBody
    public List<Task> findAll() {
        return service.findAll();
    }

    @GetMapping("task/{id}")
    @ResponseBody
    public Task findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("task")
    @ResponseBody
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping("task")
    @ResponseBody
    public Task update(@RequestBody Task task) {
        return service.update(task);
    }

    @DeleteMapping("task/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}