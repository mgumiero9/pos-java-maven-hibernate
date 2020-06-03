package posjavamavenhibernate;

import dao.GenericDAO;
import model.MGUser;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void hibernateTest() {
        HibernateUtil.getEntityManager();
    }

    @Test
    public void persistTest() {
        GenericDAO<Object> objectGenericDAO = new GenericDAO<Object>();

        MGUser user = new MGUser();
        user.setName("Ray Conniff");
        user.setUsername("rconiff");
        user.setPassword("BestConductorWithGod");

        objectGenericDAO.persist(user);
    }

}
