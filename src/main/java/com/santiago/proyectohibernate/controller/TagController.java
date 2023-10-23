package com.santiago.proyectohibernate.controller;

import com.santiago.proyectohibernate.entities.Tag;
import com.santiago.proyectohibernate.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping
    @ResponseBody
    public List<Tag> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Tag findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Tag create(@RequestBody Tag tag) {
        return service.create(tag);
    }

    @PutMapping
    @ResponseBody
    public Tag update(@RequestBody Tag tag) {
        return service.update(tag);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteByID(id);
    }
}
