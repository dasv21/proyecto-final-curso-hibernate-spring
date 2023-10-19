package com.santiago.proyectohibernate.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

    @Autowired
    private EntityManagerFactory managerFactory;

    @Bean
    public Session getSession(){

        SessionFactory sessionFactory = managerFactory.unwrap(SessionFactory.class);
        return sessionFactory.openSession();
    }
}
