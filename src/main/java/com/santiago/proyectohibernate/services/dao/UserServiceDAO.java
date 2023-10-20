package com.santiago.proyectohibernate.services.dao;

import com.santiago.proyectohibernate.dao.UserDAOImpl;
import com.santiago.proyectohibernate.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDAO {
    @Autowired
    private UserDAOImpl repository;

    public User create(User user) {
        return repository.create(user);
    }

    public User update(User user) {
        return repository.update(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id);
    }

    public List<User> findActive() {
        return repository.findActive();
    }

    public List<User> findInactive() {
        return repository.findInactive();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
