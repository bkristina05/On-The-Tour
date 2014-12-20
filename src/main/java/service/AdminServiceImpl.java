package service;

import domain.TypeName;
import domain.User;
import domain.UserType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 20.12.2014.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Поиск пользователя по логину
     * @param login_find
     * @return
     */
    @Transactional
    @Override
    public User find_user(String login_find) {
        List<User>resultList=sessionFactory.getCurrentSession().createSQLQuery("select * from users where login= '"+login_find+"'").addEntity(User.class).list();
        if(resultList.isEmpty())return  null;
        else return(resultList.get(0));
    }

    /**
     * список ролей пользователей приложения
      * @return
     */
    @Transactional
    @Override
    public List<TypeName> nameOfType() {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from type_name").addEntity(TypeName.class).list();
    }

    /**
     * id типа пользователя
     * @param login_find логин пользователя, для которого определяется id
     * @return
     */
    @Transactional
    @Override
    public int id_user_type(String login_find) {
        int result=0;
        User user=find_user(login_find);
        int id_user=0;
        if(user!=null) id_user=user.getUser_id();
        else return 0;
        List<UserType>resultList=sessionFactory.getCurrentSession().createSQLQuery("select * from user_type where user_id='"+id_user+"'").addEntity(UserType.class).list();
        if(resultList.isEmpty())return 0;
        else return resultList.get(0).getType_id();
    }
}
