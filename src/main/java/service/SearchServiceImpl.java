package service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transferObjects.Excursion;

import java.math.BigInteger;
import java.util.*;

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
                                                "FROM Excursion ");
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
                                "  (e.max_tourists - eg.tourist_quantity) AS available_quantity " +
                                "FROM Excursion e " +
                                "  JOIN Excurs_Guide eg ON e.excurs_id = eg.excurs_id " +
                                "WHERE e.town=:town"
        );
        List<Excursion> excursions = new LinkedList<>();

        List<Object[]> rows = sqlQuery.setParameter("town",town).list();

        for (Object[] column : rows) {
            String place = (String) column[0];

            Long timestamp = ((BigInteger) column[1]).longValue();
            DateTime dateTime = new DateTime(timestamp*1000);

            Integer availableQuantity = (Integer) column[2];

            excursions.add(new Excursion(place, availableQuantity, dateTime));
        }

        return excursions;
    }




}


