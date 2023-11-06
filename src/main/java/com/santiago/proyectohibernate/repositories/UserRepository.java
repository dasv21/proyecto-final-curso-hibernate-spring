package com.santiago.proyectohibernate.repositories;

import com.santiago.proyectohibernate.entities.User;
import com.santiago.proyectohibernate.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByDni(String dni);

    @Query("SELECT u.id AS id, u.firstName AS firstName, u.email AS email, u.dni AS dni, u.active AS active FROM User u")
    List<UserProjection> findAllUserProjections();

    @Query("SELECT u.id AS id, u.firstName AS firstName, u.email AS email, u.dni AS dni, u.active AS active FROM User u WHERE u.active = true")
    List<UserProjection> findByActiveTrue();

    @Query("SELECT u.id AS id, u.firstName AS firstName, u.email AS email, u.dni AS dni, u.active AS active FROM User u WHERE u.active = false")
    List<UserProjection> findByActiveFalse();
}
