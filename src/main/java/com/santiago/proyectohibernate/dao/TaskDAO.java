package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.Task;

import java.util.List;

public interface TaskDAO {

    Task create(Task task);

    Task update(Task task);

    List<Task> findAll();

    Task findById(Long id);

    Boolean deleteById(Long id);
}
