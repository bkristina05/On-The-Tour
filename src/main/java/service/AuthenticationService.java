package service;

import domain.User;

public interface AuthenticationService {

	public boolean addUser(User user);
    public boolean checkAuthorization(String login, String password);
    public boolean checkForTheExistenceLogin(String login);
    public boolean checkForTheExistenceEmail(String email);

}
