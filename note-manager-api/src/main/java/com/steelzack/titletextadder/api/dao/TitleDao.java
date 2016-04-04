package com.steelzack.titletextadder.api.dao;

import com.steelzack.titletextadder.api.model.Title;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TitleDao implements TitleDaoInterface<Title> {
    private EntityTransaction currentTransaction;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public TitleDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("note.manager.app.jpa");
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
    }


    private EntityTransaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void persist(Title entity) {
        entityManager = entityManagerFactory.createEntityManager();
        currentTransaction = entityManager.getTransaction();
        currentTransaction.begin();
        entityManager.persist(entity);
    }

    public void update(Title entity) {
        entityManager = entityManagerFactory.createEntityManager();
        currentTransaction = entityManager.getTransaction();
        currentTransaction.begin();
        entityManager.refresh(entity);
    }

    public void delete(Title entity) {
        entityManager = entityManagerFactory.createEntityManager();
        currentTransaction = entityManager.getTransaction();
        currentTransaction.begin();
        entityManager.remove(entity);
    }

}