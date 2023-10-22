package com.santiago.proyectohibernate.services;

import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.projection.UserProjection;
import com.santiago.proyectohibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<UserProjection> findAllUserProjection() {
        return repository.findAllUserProjections();
    }

    public List<User> findActive() {
        return repository.findByActiveTrue();
    }

    public List<User> findInactive() {
        return repository.findByActiveFalse();
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteByID(Long id) {
        repository.deleteById(id);
    }
}
