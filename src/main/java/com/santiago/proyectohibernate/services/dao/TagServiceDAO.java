package com.santiago.proyectohibernate.services.dao;

import com.santiago.proyectohibernate.dao.TagDAOImpl;
import com.santiago.proyectohibernate.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceDAO {
    @Autowired
    private TagDAOImpl repository;

    public Tag create(Tag tag) {
        return repository.create(tag);
    }

    public Tag update(Tag tag) {
        return repository.update(tag);
    }

    public List<Tag> findAll() {
        return repository.findAll();
    }

    public Tag findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
