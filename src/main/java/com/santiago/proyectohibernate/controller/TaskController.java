package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.Task;
import com.santiago.proyectohibernate.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping
    @ResponseBody
    public List<Task> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Task findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping
    @ResponseBody
    public Task update(@RequestBody Task task) {
        return service.update(task);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteByID(id);
    }
}
