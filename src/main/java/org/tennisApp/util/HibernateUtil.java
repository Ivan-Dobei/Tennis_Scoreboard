package org.tennisApp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tennisApp.entity.PlayerEntity;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(PlayerEntity.class)
                    .buildSessionFactory();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to build SessionFactory", ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

