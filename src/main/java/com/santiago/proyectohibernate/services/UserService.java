package com.santiago.proyectohibernate.services;

import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.exception.RequestValidateException;
import com.santiago.proyectohibernate.projection.UserProjection;
import com.santiago.proyectohibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User create(User user) {

        if (userRepository.findByDni(user.getDni()) != null) {
            throw new RequestValidateException("Dni is already registered with another user", HttpStatus.CONFLICT);
        }
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }


    public List<UserProjection> findAllUserProjection() {
        return userRepository.findAllUserProjections();
    }

    public List<UserProjection> findActive() {
        return userRepository.findByActiveTrue();
    }

    public List<UserProjection> findInactive() {
        return userRepository.findByActiveFalse();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

}
