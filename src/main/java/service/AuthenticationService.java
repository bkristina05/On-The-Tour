package service;

import domain.User;

public interface AuthenticationService {

	public boolean addUser(User user);
    public boolean checkAuthorization(String login, String password);

}
