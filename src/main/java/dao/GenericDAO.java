package dao;

import posjavamavenhibernate.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAO<E> {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();

    public void persist(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public E search(E entity) {
        Object id = HibernateUtil.getPrimaryKey(entity);
        return searchById((Long) id, entity.getClass());
    }

    public E searchById(Long id, Class genericClass) {
        E e = (E) entityManager.find(genericClass, id);
        return e;

    }

}
