package org.tennisApp.DAO;

import org.hibernate.Session;
import org.tennisApp.entity.PlayerEntity;
import org.tennisApp.util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class PlayerDAO {


    public PlayerDAO() {}

    public Long addNew(PlayerEntity player) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(player);

            session.getTransaction().commit();
            return player.getId();
        }
    }

    public List<PlayerEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            return session.createQuery("SELECT a FROM PlayerEntity a", PlayerEntity.class).getResultList();
        }
    }

    public Optional<PlayerEntity> findByName(String name) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            List <PlayerEntity> queryResult = session.createQuery(
                            "SELECT player FROM PlayerEntity player WHERE player.name = :name",
                            PlayerEntity.class)
                    .setParameter("name", name)
                    .getResultList();

            if(queryResult.isEmpty()) {
                return Optional.empty();
            }
            return Optional.ofNullable(queryResult.get(0));
        }
    }
}
