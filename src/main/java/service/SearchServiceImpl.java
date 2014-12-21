package service;

import domain.ExcursionTourist;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transferObjects.Excursion;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daria on 14.12.2014.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<String> getTowns() {
        Session session = sessionFactory.openSession();
        Query sqlQuery = session.createSQLQuery("SELECT distinct " +
                " town " +
                "FROM excursion ");
        List<String> towns = new LinkedList<>();

        List<Object> rows = sqlQuery.list();

        for (Object row : rows) {
            String town = (String) row;
            towns.add(town);
        }
        return towns;
    }

    @Override
    @Transactional
    public List<Excursion> getExcursions(String town) {

        Session session = sessionFactory.openSession();
        Query sqlQuery = session.createSQLQuery(
                "SELECT " +
                        "  e.place, " +
                        "  date_excurs, " +
                        "  (e.max_tourists - eg.tourist_quantity) AS available_quantity, " +
                        "  e.duration_tour, " +
                        "  eg.seq_excurs_guide, " +
                        "  e.price, " +
                        "  e.description " +
                        "FROM Excursion e " +
                        "  JOIN Excurs_Guide eg ON e.excurs_id = eg.excurs_id " +
                        "WHERE e.town=:town"
        );
        List<Excursion> excursions = new LinkedList<>();

        List<Object[]> rows = sqlQuery.setParameter("town", town).list();

        for (Object[] column : rows) {
            String place = (String) column[0];

            Long timestamp = ((BigInteger) column[1]).longValue();
            DateTime dateTime = new DateTime(timestamp * 1000);

            if (dateTime.getMillis() < DateTime.now().getMillis()) continue;
            Integer availableQuantity = (Integer) column[2];

            Integer duration = (Integer) column[3];

            Integer idExcursion = (Integer) column[4];

            Double price = (Double) column[5];

            String description = (String) column[6];

            excursions.add(new Excursion(idExcursion, town, place, availableQuantity, dateTime, duration, price, description));
        }

        return excursions;
    }


    @Override
    @Transactional
    public Integer reserve(Integer idExcursion, String login, Integer numberPersons) {
        Session session = sessionFactory.openSession();
        Query sqlQuery = session.createSQLQuery(
                "SELECT user_id from users where login=:login"
        );
        List<Object> rows = sqlQuery.setParameter("login", login).list();
        if (rows.isEmpty()) return -1;
        else {

            Integer userId = (Integer) rows.get(0);
            System.out.println("userId = " + userId);

            ExcursionTourist excursionTourist = new ExcursionTourist(userId, idExcursion, numberPersons);

            sessionFactory.getCurrentSession().save(excursionTourist);
            Integer sequence_id = excursionTourist.getSequence_id();

            System.out.println("sequence_id = " + sequence_id);

            Session session2 = sessionFactory.getCurrentSession();
            session2.createSQLQuery("UPDATE excurs_guide " +
                    "SET tourist_quantity=(tourist_quantity + :numberPersons) " +
                    "WHERE seq_excurs_guide=:idExcursion").
                    setParameter("numberPersons", numberPersons).
                    setParameter("idExcursion", idExcursion).
                    executeUpdate();
            return sequence_id;
        }

    }


    @Override
    @Transactional
    public List<Excursion> getReservedExcursions(String login) {
        Session session = sessionFactory.openSession();
        Query sqlQuery = session.createSQLQuery(
                "SELECT user_id from users where login=:login"
        );
        List<Object> rows = sqlQuery.setParameter("login", login).list();

        List<Excursion> excursions = new LinkedList<>();

        if (!rows.isEmpty()) {

            Integer userId = (Integer) rows.get(0);
            System.out.println("userId = " + userId);
            Query sqlQuery2 = sessionFactory.getCurrentSession().createSQLQuery(
                    "SELECT DISTINCT excursion.town, " +
                            "excursion.place, " +
                            "excurs_tourist.tourist_quantity, " +
                            "excursion.price, " +
                            "excursion.duration_tour, " +
                            "excurs_guide.date_excurs, " +
                            "users.name, " +
                            "users.phone, " +
                            "users.email, " +
                            "excurs_tourist.excurs_guide_seq "+
                            " FROM excursion " +
                            "JOIN excurs_guide ON excursion.excurs_id = excurs_guide.excurs_id " +
                            "JOIN excurs_tourist ON excurs_guide.seq_excurs_guide = excurs_tourist.excurs_guide_seq " +
                            "JOIN users ON users.user_id = excurs_guide.user_guide_id  " +
                            "WHERE excurs_tourist.user_id=:userId "
            );


            List<Object[]> rows2 = sqlQuery2.setParameter("userId", userId).list();

            for (Object[] column : rows2) {
                String town = (String) column[0];
                String place = (String) column[1];
                Integer numberOfReserved = (Integer) column[2];
                Double price = (Double) column[3]* numberOfReserved;
                Integer duration = (Integer) column[4];

                Long timestamp = ((BigInteger) column[5]).longValue();
                DateTime dateTime = new DateTime(timestamp * 1000);

                String name = (String) column[6];
                String phone = (String) column[7];
                String email = (String) column[8];


                Integer idExcursion = (Integer) column[9];

                excursions.add(new Excursion(price, town, place, dateTime, duration, name, phone, email, numberOfReserved,idExcursion));
            }
        }
        return excursions;
    }
}

