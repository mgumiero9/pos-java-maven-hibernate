package posjavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory factory = null;

    static {
        init();
    }

    private static void init() {
        try {
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
            }
        } catch (Exception e) {
            System.out.println("exception: ");
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static Object getPrimaryKey(Object entity) {
        return factory.getPersistenceUnitUtil().getIdentifier(entity);
    }

}
