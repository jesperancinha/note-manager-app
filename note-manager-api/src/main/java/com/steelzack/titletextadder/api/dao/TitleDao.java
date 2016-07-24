package com.steelzack.titletextadder.api.dao;

import com.steelzack.titletextadder.api.model.TitleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class TitleDao implements TitleDaoInterface<TitleEntity> {
    private EntityTransaction currentTransaction;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public TitleDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("note.manager.app.jpa");
    }

    public void persist(TitleEntity entity) {
        entityManager = entityManagerFactory.createEntityManager();
        currentTransaction = entityManager.getTransaction();
        currentTransaction.begin();
        entityManager.persist(entity);
        currentTransaction.commit();

    }

    public void update(TitleEntity entity) {
        entityManager = entityManagerFactory.createEntityManager();
        currentTransaction = entityManager.getTransaction();
        currentTransaction.begin();
        entityManager.refresh(entity);
        currentTransaction.commit();

    }

    public void delete(TitleEntity entity) {
        entityManager = entityManagerFactory.createEntityManager();
        currentTransaction = entityManager.getTransaction();
        currentTransaction.begin();
        entityManager.remove(entity);
        currentTransaction.commit();
    }

}