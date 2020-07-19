package posjavamavenhibernate;

import dao.GenericDAO;
import model.MGUser;
import model.UserPhone;
import org.junit.Test;

import javax.persistence.Table;
import java.util.List;

public class HibernateTest {

    @Test
    public void hibernateTest() {
        HibernateUtil.getEntityManager();
    }

    @Test
    public void persistTest() {
        GenericDAO<Object> objectGenericDAO = new GenericDAO<Object>();
        MGUser user = new MGUser();
        user.setName("Ray Conniff5");
        user.setUsername("rconiff5");
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

    @Test
    public void updateMergeTest() {
        GenericDAO<MGUser> genericDAO = new GenericDAO<MGUser>();
        MGUser user = genericDAO.searchById(2L, MGUser.class);
        user.setName("Mr. Ray Conniff");
        MGUser updatedUser = genericDAO.updateMerge(user);
        System.out.println(updatedUser);
    }

    @Test
    public void deleteTest() {
        GenericDAO<MGUser> genericDAO = new GenericDAO<MGUser>();
        MGUser user = genericDAO.searchById(4L, MGUser.class);
        genericDAO.delete(user);
        System.out.println("deleted user " + user.getName());
    }

    @Test
    public void listAllTest() {
        GenericDAO<MGUser> dao = new GenericDAO<MGUser>();
        List<MGUser> mgUsers = dao.listAll(MGUser.class);
        System.out.println(mgUsers);
    }

    @Test
    public void queryListTest() {
        GenericDAO<MGUser> dao = new GenericDAO<MGUser>();
        List<MGUser> resultList1 = dao.getEntityManager().createQuery("select t from MGUser t").getResultList();
        for (MGUser user : resultList1) {
            System.out.println(user);
        }
        /* Other query example, shorter... */
        List<MGUser> resultList2 = dao.getEntityManager().createQuery(" from MGUser").getResultList();
        for (MGUser user : resultList2) {
            System.out.println(user);
        }
    }

    @Test
    public void queryListTestMaxResult() {
        GenericDAO<MGUser> dao = new GenericDAO<MGUser>();
        List<MGUser> resultList1 = dao.getEntityManager()
                .createQuery("select t from MGUser t")
                .setMaxResults(2)
                .getResultList();
        for (MGUser user : resultList1) {
            System.out.println(user);
        }
    }

    @Test
    public void queryListParameterTest() {
        GenericDAO<MGUser> dao = new GenericDAO<MGUser>();
        List<MGUser> resultList1 = dao.getEntityManager()
                .createQuery("select t from MGUser t where t.name = :name or t.password = :password")
                .setParameter("name", "Ray Conniff")
                .setParameter("password", "BestConductorWithGod")
                .getResultList();
        for (MGUser user : resultList1) {
            System.out.println(user);
        }
    }

    @Test
    public void getStatistics() {
        GenericDAO<MGUser> dao = new GenericDAO<MGUser>();
        Object idSum = dao.getEntityManager()
                .createQuery("select sum(u.id) from MGUser u")
                .getSingleResult();
        Object idAvg = dao.getEntityManager()
                .createQuery("select avg(u.id) from MGUser u")
                .getSingleResult();
        System.out.println(String.format("sum: %s", idSum));
        System.out.println(String.format("avg: %s", idAvg));
    }

    @Test
    public void getAllIds() {
        GenericDAO<MGUser> dao = new GenericDAO<MGUser>();
        List<Long> resultList = (List<Long>) dao.getEntityManager()
                .createNamedQuery("MGUser.getAllIds")
                .getResultList();
        resultList.forEach(id -> System.out.println(String.format("id: %s", id)));
    }

    @Test
    public void savePhone() {
        GenericDAO<Object> genericDAO = new GenericDAO<>();
        MGUser mgUser = (MGUser) genericDAO.searchById(2L, MGUser.class);
        UserPhone phone = new UserPhone();
        phone.setType("Celular");
        phone.setNumber("22-22222-2222");
        phone.setMgUser(mgUser);
        genericDAO.persist(phone);
    }

}
