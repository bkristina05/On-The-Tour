package service;

import domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
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
        try {
            sessionFactory.getCurrentSession().save(user);
            return true;
        }catch (ConstraintViolationException e){
            return false;
        }
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
