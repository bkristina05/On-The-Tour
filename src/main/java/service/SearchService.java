package service;

import org.joda.time.DateTime;

import java.util.Map;

/**
 * Created by Daria on 14.12.2014.
 */
public interface SearchService {
    public Map<DateTime,Integer> searchTours (String town, String place);
}
