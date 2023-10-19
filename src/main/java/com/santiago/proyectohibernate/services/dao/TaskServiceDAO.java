package com.santiago.proyectohibernate.services.dao;

import com.santiago.proyectohibernate.dao.TaskDAOImpl;
import com.santiago.proyectohibernate.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceDAO {
    @Autowired
    private TaskDAOImpl repository;

    public Task create(Task task) {
        return repository.create(task);
    }

    public Task update(Task task) {
        return repository.update(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
