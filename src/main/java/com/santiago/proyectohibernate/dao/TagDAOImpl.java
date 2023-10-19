package com.santiago.proyectohibernate.dao;

import com.santiago.proyectohibernate.entities.Tag;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    @Autowired
    private Session session;

    @Override
    public Tag create(Tag tag) throws PersistenceException {

        try {
            session.beginTransaction();
            session.persist(tag);
            session.getTransaction().commit();
            return tag;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Tag update(Tag tag) throws PersistenceException {
        try {
            session.beginTransaction();
            session.merge(tag);
            session.getTransaction().commit();
            return tag;
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return session.createQuery("from Tag", Tag.class).list();
    }

    @Override
    public Tag findById(Long id) {
        return session.find(Tag.class, id);
    }

    @Override
    public Boolean deleteById(Long id) throws PersistenceException {
        try {
            session.beginTransaction();
            Tag tag = findById(id);
            session.remove(tag);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
