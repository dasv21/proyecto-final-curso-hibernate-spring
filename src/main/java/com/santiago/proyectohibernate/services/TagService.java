package com.santiago.proyectohibernate.services;

import com.santiago.proyectohibernate.entities.Tag;
import com.santiago.proyectohibernate.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository repository;

    public Tag create(Tag tag) {
        return repository.save(tag);
    }

    public Tag update(Tag tag) {
        return repository.save(tag);
    }

    public List<Tag> findAll() {
        return repository.findAll();
    }

    public Tag findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteByID(Long id) {
        repository.deleteById(id);
    }
}
