package service;

import domain.Excursion;
import domain.ExcursionTourist;


import java.util.Set;

/**
 * Created by Igor on 17.12.2014.
 */
public interface GuideService {
    public Set<domain.User> getListTourists(int excurs_id, int guide_id);
    public java.util.Map<domain.ExcursionGuide, Excursion> getListExcursions(int guide_id);
    public int getIdUser(String user_login);
    public String getTypeName(int user_id);
}
