import java.util.List;

/**
 * Created by Daria on 23.10.2014.
 */
public interface Dao {

    java.util.List<User> getUsers();

    void createTableIfNotExist();

    List<User> getAllUnit();
}
