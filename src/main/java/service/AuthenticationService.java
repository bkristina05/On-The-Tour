package service;

import domain.User;

public interface AuthenticationService {

	public void addContact(User user);
    public void checkAuthorization(String login, String password);

}
