package com.internship.util;

import com.internship.entities.Certificates;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml").addAnnotatedClass(Certificates.class)
                        .buildSessionFactory();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error creating session factory: " + e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
