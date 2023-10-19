package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.User;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private Session session;


    @Override
    public User create(User user) throws PersistenceException {

        try {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            return user;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public User update(User user) throws PersistenceException {
        try {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
            return user;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return session.createQuery("from User", User.class).list();
    }

    @Override
    public User findById(Long id) {
        return session.find(User.class, id);
    }

    @Override
    public List<User> findActivos() {

        // 1. criteria
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        Predicate filter = builder.equal(root.get("activo"), true);

        criteria.select(root).where(filter);

        // 2. query
        List<User> users = session.createQuery(criteria).list();

        return users;
    }

    @Override
    public List<User> findInactivos() {

        // 1. criteria
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        Predicate filter = builder.equal(root.get("activo"), false);

        criteria.select(root).where(filter);

        // 2. query
        List<User> users = session.createQuery(criteria).list();

        return users;
    }

    @Override
    public Boolean deleteById(Long id) throws PersistenceException {
        try {
            session.beginTransaction();
            User user = findById(id);
            session.remove(user);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
