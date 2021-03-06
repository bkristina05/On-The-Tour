package service;

import transferObjects.Excursion;

import java.util.List;

/**
 * Created by Daria on 14.12.2014.
 */
public interface SearchService {
    public List<String> getTowns();
    public List<Excursion> getExcursions(String town);
    public Integer reserve(Integer idExcursion, String login, Integer numberPersons);
    public List<Excursion> getReservedExcursions (String login);
    public boolean deleteExcursons (String login, Integer idExcursion);
    public void changeQuantity (Integer userId);
}
