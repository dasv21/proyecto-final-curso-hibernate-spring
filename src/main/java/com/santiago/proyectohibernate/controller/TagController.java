package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.Tag;
import com.santiago.proyectohibernate.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TagController {

    @Autowired
    TagService service;

    @GetMapping("tag")
    @ResponseBody
    public List<Tag> findAll() {
        return service.findAll();
    }

    @GetMapping("tag/{id}")
    @ResponseBody
    public Tag findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("tag")
    @ResponseBody
    public Tag create(@RequestBody Tag tag) {
        return service.create(tag);
    }

    @PutMapping("tag")
    @ResponseBody
    public Tag update(@RequestBody Tag tag) {
        return service.update(tag);
    }

    @DeleteMapping("tag/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteByID(id);
    }
}
