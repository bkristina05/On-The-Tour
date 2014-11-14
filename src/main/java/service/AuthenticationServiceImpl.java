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
    public void addContact(User user) {
       sessionFactory.getCurrentSession().save(user);
    }


    public void checkAuthorization(String login, String password){
        
    }

}
