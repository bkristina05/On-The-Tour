package service;

import domain.TypeName;
import domain.User;

import java.util.List;

/**
 * Created by Igor on 20.12.2014.
 */
public interface AdminService {
    public User find_user(String login_find);
    public List<TypeName>nameOfType();
    public int id_user_type(String login_find);
}
