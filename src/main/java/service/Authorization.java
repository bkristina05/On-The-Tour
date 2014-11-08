package service;

/**
 * Created by Daria on 08.11.2014.
 */
public interface Authorization {
    boolean isOk(String login, String password);
}
