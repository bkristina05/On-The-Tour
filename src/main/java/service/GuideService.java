package service;

import domain.Excursion;
import domain.ExcursionTourist;


import java.util.List;
import java.util.Set;

/**
 * Created by Igor on 17.12.2014.
 */
public interface GuideService {
    public Set<domain.User> getListTourists(int excurs_id, int guide_id);
    public java.util.Map<domain.ExcursionGuide, Excursion> getListExcursions(int guide_id);
    public int getIdUser(String user_login);
    public String getTypeName(int user_id);
    public List<ExcursionTourist> listExcursionTouris(int excurs_id, int guide_id);
    public void appointExcursion(Integer excurs_id, Integer user_guide_id, Long date_excurs);
}
