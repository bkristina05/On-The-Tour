package service;

import domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public boolean addContact(User user){
        sessionFactory.getCurrentSession().save(user);
        Integer user_id = user.getUser_id();
        System.out.println("user_id = " + user_id);
//        UserType userType = new UserType(user_id,"user");
//        sessionFactory.getCurrentSession().save(userType);
        return true;
    }

    @Override
    public void checkAuthorization(String login, String password){
        
    }
    @Override
    public boolean userNotExists(String login, String password, String email){
       // sessionFactory.getCurrentSession().f


        return false;

    }


}
