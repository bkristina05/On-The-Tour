package service;

import transferObjects.Excursion;

import java.util.List;

/**
 * Created by Daria on 14.12.2014.
 */
public interface SearchService {
    public List<String> getTowns();
    public List<Excursion> getExcursions(String town);
}
