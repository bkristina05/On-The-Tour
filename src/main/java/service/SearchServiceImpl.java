package service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daria on 14.12.2014.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Map<DateTime,Integer> searchTours (String town, String place) {

        Session session = sessionFactory.openSession();
        Query sqlQuery = session.createSQLQuery("SELECT " +
                "  date_excurs," +
                "  (max_tourists - tourist_quantity) AS count " +
                "FROM Excursion " +
                "JOIN Excurs_Guide ON Excursion.excurs_id = Excurs_Guide.excurs_id " +
                "WHERE Excursion.town = :town AND Excursion.place = :place ");

        List<Object[]> rows = sqlQuery.setParameter("town", town).setParameter("place",place).list();
        Map<DateTime,Integer>  dateTimeIntegerMap = new HashMap<>();

        for (Object[] row : rows) {
            Long timestamp = ((BigInteger) row[0]).longValue();
            DateTime dateTime = new DateTime(timestamp*1000);
            Integer availableQuantity = (Integer) row[1];
            dateTimeIntegerMap.put(dateTime,availableQuantity);
        }

        return  dateTimeIntegerMap;
    }


}


