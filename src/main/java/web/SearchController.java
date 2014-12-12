package web;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 20.11.2014.
 */
@Controller
public class SearchController {
    @Autowired
    private SessionFactory sessionFactory;

    public List<String> selectTown(){
        List<Object[]> rows = sessionFactory.getCurrentSession().createSQLQuery("select * from Excursion").list();
        List<String> towns = new ArrayList<>(rows.size());
        for(Object[] row : rows){
            String town = (String) row[0];
            towns.add(town);
        }
        return towns;
    }

}
