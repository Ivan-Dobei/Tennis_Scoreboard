package org.tennisApp.DAO;

import org.hibernate.Session;
import org.tennisApp.entity.PlayerEntity;
import org.tennisApp.util.HibernateUtil;

import java.util.List;

public class PlayerDAO {


    public PlayerDAO() {}

    public void addNew(PlayerEntity player) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(player);

            session.getTransaction().commit();
        }
    }

    public List<PlayerEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            return session.createQuery("SELECT a FROM PlayerEntity a", PlayerEntity.class).getResultList();
        }
    }
}
