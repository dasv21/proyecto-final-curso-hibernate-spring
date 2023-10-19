package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.Tag;

import java.util.List;

public interface TagDAO {

    Tag create(Tag tag);

    Tag update(Tag tag);

    List<Tag> findAll();

    Tag findById(Long id);

    Boolean deleteById(Long id);
}
