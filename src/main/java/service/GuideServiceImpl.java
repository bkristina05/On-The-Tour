package service;

import domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Igor on 17.12.2014.
 */
@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Возвращает список туристов, записавшихся на экскурсию к гиду
     * @param excurs_id
     * @param guide_id
     * @return
     */
    @Transactional
    @Override
    public Set<User> getListTourists(int excurs_id, int guide_id) {
        List<ExcursionGuide>listSeqExcGuide=sessionFactory.getCurrentSession().createSQLQuery("select * from excurs_guide " +
                "where excurs_id="+excurs_id+" and user_guide_id="+guide_id+"").addEntity(ExcursionGuide.class).list();
        int id_seq_exc_g=0;
        if(listSeqExcGuide.isEmpty())return  new HashSet<User>();
        else {
            id_seq_exc_g=listSeqExcGuide.get(0).getSeq_excurs_guide();
        }

        List<ExcursionTourist>listTourists=sessionFactory.getCurrentSession().createSQLQuery("select * from excurs_tourist " +
                "where excurs_guide_seq='"+id_seq_exc_g+"'").addEntity(ExcursionTourist.class).list();

        Set<User>result=new HashSet<User>();
        int id_user;
        List<User>users;
        for (ExcursionTourist excT : listTourists){
            id_user=excT.getUser_id();
            users=sessionFactory.getCurrentSession().createSQLQuery("select * from users " +
                    "where user_id='"+id_user+"'").addEntity(User.class).list();
            result.addAll(users);
        }
        return result;
    }

    /**
     * Возвращает список экскурсий для гида
     * @param guide_id id гида в базе данных
     * @return
     */
    @Transactional
    @Override
    public Map<ExcursionGuide, Excursion> getListExcursions(int guide_id) {
        Map<ExcursionGuide,Excursion>result=new HashMap<ExcursionGuide,Excursion>();
        List<ExcursionGuide>list=sessionFactory.getCurrentSession().createSQLQuery("select distinct * from excurs_guide " +
                "where user_guide_id='"+guide_id+"'").addEntity(ExcursionGuide.class).list();
        List<Excursion> excursions;
        for(ExcursionGuide exc:list) {
            excursions = sessionFactory.getCurrentSession().createSQLQuery("select * from excursion " +
                    "where excurs_id='" + exc.getExcurs_id() + "'").addEntity(Excursion.class).list();
            Long time=exc.getDate_excurs();
            result.put(exc,excursions.get(0));
        }
        return result;
    }

    /**
     * возвращает id пользователя по логину
     * @param user_login
     * @return
     */
    @Transactional
    @Override
    public int getIdUser(String user_login) {
        List<User>list=sessionFactory.getCurrentSession().createSQLQuery("select * from users " +
                "where login='" + user_login + "'").addEntity(User.class).list();
        return list.get(0).getUser_id();
    }

    /**
     * возвращает тип пользователя по id
     * @param user_id
     * @return
     */
    @Transactional
    @Override
    public String getTypeName(int user_id) {
        List<UserType>list=sessionFactory.getCurrentSession().createSQLQuery("select * from user_type " +
                "where user_id='" + user_id + "'").addEntity(UserType.class).list();
        int typeId=list.get(0).getType_id();
        List<TypeName> typeName=sessionFactory.getCurrentSession().createSQLQuery("select * from type_name " +
                "where type_id='" + typeId + "'").addEntity(TypeName.class).list();
        return typeName.get(0).getType_name();
    }

    /**
     * Возвращает список заявок, содержащий id пользователей, сделавших заявки на конкретную экскурсию
     * @param excurs_id
     * @param guide_id
     * @return
     */
    @Transactional
    @Override
    public List<ExcursionTourist> listExcursionTouris(int excurs_id, int guide_id) {
        List<ExcursionGuide>listSeqExcGuide=sessionFactory.getCurrentSession().createSQLQuery("select * from excurs_guide " +
                "where excurs_id="+excurs_id+" and user_guide_id="+guide_id+"").addEntity(ExcursionGuide.class).list();
        int id_seq_exc_g=0;
        if(listSeqExcGuide.isEmpty())return  new ArrayList<>();
        else {
            id_seq_exc_g=listSeqExcGuide.get(0).getSeq_excurs_guide();
        }

        List<ExcursionTourist>listTourists=sessionFactory.getCurrentSession().createSQLQuery("select * from excurs_tourist " +
                "where excurs_guide_seq='"+id_seq_exc_g+"'").addEntity(ExcursionTourist.class).list();
        return listTourists;
    }
}
