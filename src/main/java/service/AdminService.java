package service;

import domain.Excursion;
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
    public void saveUserType(int id_user,int id_user_type);
    public List<Excursion> getListExcursion();
    public void addExcursion(Excursion excursion);
    public void updateExcursion(Excursion excursion);
    public  Excursion getExcursion(int id_excursion);
}
