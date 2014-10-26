
import org.hibernate.Session;

/**
 * Created by Daria on 23.10.2014.
 */
public class Runner {
    public static void main(String[] args) {

        showUser();
    }


    private static void showUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createCriteria(User.class).list().forEach(user -> System.out.println("user = " + user));

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

}
