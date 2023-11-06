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
    TaskService taskService;

    @GetMapping
    @ResponseBody
    public List<Task> findAll() {
        return taskService.findAll();
    }
}
