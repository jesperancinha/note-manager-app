package org.jesperancinha.titletextadder.api.dao;

import org.jesperancinha.titletextadder.api.model.TitleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class TitleDao implements TitleDaoInterface<TitleEntity> {
    private EntityTransaction currentTransaction;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

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