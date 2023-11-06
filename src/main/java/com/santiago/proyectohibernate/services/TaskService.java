package com.santiago.proyectohibernate.services;

import com.santiago.proyectohibernate.entities.Task;
import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.repositories.TaskRepository;
import com.santiago.proyectohibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public Task create(Task task, Long userId) {
        User user = userRepository.findById(userId).get();
        user.getTasks().add(task);
        userRepository.save(user);
        return task;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
