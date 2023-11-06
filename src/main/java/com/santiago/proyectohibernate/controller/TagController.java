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
    TagService tagService;

    @GetMapping
    @ResponseBody
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Tag findById(@PathVariable Long id) {
        return tagService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Tag create(@RequestBody Tag tag) {
        return tagService.create(tag);
    }

    @PutMapping
    @ResponseBody
    public Tag update(@RequestBody Tag tag) {
        return tagService.update(tag);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        tagService.deleteByID(id);
    }
}
