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

    @Test
    public void searchTest() {
        GenericDAO<Object> genericDAO = new GenericDAO<Object>();

        MGUser user = new MGUser();
        user.setId(1L);
        Object o = genericDAO.search(user);

        System.out.println(o);
    }

    @Test
    public void searchByIdTest() {
        GenericDAO<Object> genericDAO = new GenericDAO<Object>();

        Object o = genericDAO.searchById(2L, MGUser.class);

        System.out.println(o);
    }

}
