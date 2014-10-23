/**
 * Created by Daria on 23.10.2014.
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.function.Consumer;

public class TestConnection {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Dao dao = (Dao) applicationContext.getBean("Dao");

        dao.createTableIfNotExist();
        List<User> allUnit = dao.getAllUnit();
        for (User user : allUnit) {
            System.out.println("user = " + user);
        }
        List<User> users = dao.getUsers();

        for (User user : users) System.out.println("user = " + user);


    }
}
