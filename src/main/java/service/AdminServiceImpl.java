package service;

import domain.Excursion;
import domain.TypeName;
import domain.User;
import domain.UserType;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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

    @Transactional
    @Override
    public void saveUserType(int id_user, int id_user_type) {
        Session session = sessionFactory.getCurrentSession();
        session.createSQLQuery("UPDATE user_type " +
                "SET type_id=(:id_user_type) " +
                "WHERE user_id=:id_user").
                setParameter("id_user_type",id_user_type).
                setParameter("id_user",id_user).
                executeUpdate();
    }

    @Transactional
    @Override
    public List<Excursion> getListExcursion() {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from excursion").addEntity(Excursion.class).list();
    }

    @Transactional
    @Override
    public void addExcursion(Excursion excursion) {

        sessionFactory.getCurrentSession().save(excursion);
    }

    @Transactional
    @Override
    public void updateExcursion(Excursion excursion) {
        Session session = sessionFactory.getCurrentSession();
        session.createSQLQuery("UPDATE excursion " +
                "SET place=(:place),town=(:town),max_tourists=(:max_tourists)," +
                "price=(:price),duration_tour=(:duration_tour),description=(:description) " +
                "WHERE excurs_id=(:id)").
                setParameter("place",excursion.getPlace()).
                setParameter("town",excursion.getTown()).
                setParameter("max_tourists",excursion.getMax_tourists()).
                setParameter("price",excursion.getPrice()).
                setParameter("duration_tour",excursion.getDuration_tour()).
                setParameter("description",excursion.getDescription()).setParameter("id",excursion.getExcurs_id()).
                executeUpdate();
    }


    @Transactional
    @Override
    public Excursion getExcursion(int id_excursion) {
        return (Excursion)sessionFactory.getCurrentSession().createSQLQuery("select * from excursion where excurs_id="+id_excursion).addEntity(Excursion.class).list().get(0);
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from users").addEntity(User.class).list();
    }

    @Transactional
    @Override
    public List<UserType> userType() {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from user_type").addEntity(UserType.class).list();
    }
}
