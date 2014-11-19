package service;

import domain.User;
import domain.UserType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    @Override
    public boolean addUser(User user){
        sessionFactory.getCurrentSession().save(user);
        Integer user_id = user.getUser_id();
        System.out.println("user_id = " + user_id);
        UserType userType = new UserType(3, user_id);
        sessionFactory.getCurrentSession().save(userType);
        return true;
    }

    @Transactional
    @Override
    public boolean checkAuthorization(String login, String password) {

        List<User> list = sessionFactory.getCurrentSession().
                createSQLQuery("select * from Users where login = '" + login + "' and password = '" + password + "'").
                addEntity(User.class).list();
        if (list == null || list.isEmpty()) return false;

        if (list.size() == 1) {
            User user = list.get(0);
            Integer user_id = user.getUser_id();
            List<UserType> listUser_type = sessionFactory.getCurrentSession().createSQLQuery("select * from User_Type where user_id ='" + user_id + "'").addEntity(UserType.class).list();
            if(listUser_type == null || listUser_type.isEmpty() )return false;
            return true;
        }
        return false;
    }




}
