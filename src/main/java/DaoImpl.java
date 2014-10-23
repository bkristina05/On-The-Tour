import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daria on 23.10.2014.
 */
public class DaoImpl implements Dao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTableIfNotExist() {
        String sql1 = "CREATE TABLE if not exists Users_copy\n" +
                "(\n" +
                "  user_id serial NOT NULL,\n" +
                "  login text,\n" +
                "  password text,\n" +
                "  name text,\n" +
                "  age smallint,\n" +
                "  town text,\n" +
                "  email text,\n" +
                "  phone text\n" +
                ")";

        String sql = "CREATE TABLE IF NOT EXISTS sites (site TEXT NOT NULL,login TEXT NOT NULL,password TEXT NOT NULL)";
        jdbcTemplate.update(sql1+";" +sql);

        System.out.println("Таблица с паролями создана");
    }

    @Override
    public List<User> getAllUnit() {
        String sql = "SELECT * FROM sites";

        List<User> query = jdbcTemplate.query(sql, (resultSet, i) -> {
            User user = new User();
            user.setEmail(resultSet.getString(1));
            return user;
        });
        System.out.println("Таблица sites загружена в память");
        return query;


    }
    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from Type_Name", (resultSet, i) -> {
            System.out.print("resultSet.getString(1) = " + resultSet.getString(1));
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            return null;
        });
    }

    public static void main(String[] args) {
        new DaoImpl().getUsers();
    }
}
