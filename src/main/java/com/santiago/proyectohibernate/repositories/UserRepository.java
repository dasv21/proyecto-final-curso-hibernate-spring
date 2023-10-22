package com.santiago.proyectohibernate.repositories;

import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.id AS id, u.firstName AS firstName, u.dni AS dni, u.active AS active FROM User u")
    List<UserProjection> findAllUserProjections();

    List<User> findByActiveTrue();

    List<User> findByActiveFalse();
}
