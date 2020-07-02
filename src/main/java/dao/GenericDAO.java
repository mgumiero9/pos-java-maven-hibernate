package dao;

import posjavamavenhibernate.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class GenericDAO<E> {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();

    public void persist(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public E updateMerge(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        E storedEntity = entityManager.merge(entity);
        transaction.commit();
        return storedEntity;
    }

    public void delete(E entity) {
        Object id = HibernateUtil.getPrimaryKey(entity);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String query = String.format("delete from %s where id = %s", entity.getClass().getSimpleName(), id);
        entityManager.createNativeQuery(query).executeUpdate();
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

    public List<E> listAll(Class<E> entityClass) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<E> resultList = entityManager
                .createQuery(String.format("FROM %s", entityClass.getSimpleName()))
                .getResultList();
        transaction.commit();
        return resultList;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
