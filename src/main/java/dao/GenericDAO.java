package dao;

import posjavamavenhibernate.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAO<T> {

    private EntityManager entityManager = HibernateUtil.getEntityManager();

    public void persist(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

}
