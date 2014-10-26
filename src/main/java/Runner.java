

import org.hibernate.Session;

/**
 * Created by Daria on 23.10.2014.
 */
public class Runner {
    public static void main(String[] args) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user1 = new User("dasha","tfh","fhh",21,"fh","fhd","356");
        session.save(user1);
        session.createCriteria(User.class).list().forEach(user -> System.out.println("user = " + user));

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

}
