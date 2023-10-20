package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.User;

import java.util.List;

public interface UserDAO {

    User create(User user);

    User update(User user);

    List<User> findAll();

    User findById(Long id);

    List<User> findActive();

    List<User> findInactive();

    Boolean deleteById(Long id);
}
