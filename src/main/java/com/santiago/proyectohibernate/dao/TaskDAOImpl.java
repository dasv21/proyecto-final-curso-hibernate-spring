package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.Task;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private Session session;

    @Override
    public Task create(Task task) throws PersistenceException {

        try {
            session.beginTransaction();
            session.persist(task);
            session.getTransaction().commit();
            return task;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Task update(Task task) throws PersistenceException {
        try {
            session.beginTransaction();
            session.merge(task);
            session.getTransaction().commit();
            return task;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Task> findAll() {
        return session.createQuery("from Task", Task.class).list();
    }

    @Override
    public Task findById(Long id) {
        return session.find(Task.class, id);
    }

    @Override
    public Boolean deleteById(Long id) throws PersistenceException {
        try {
            session.beginTransaction();
            Task task = findById(id);
            session.remove(task);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
