package service;

import domain.User;

public interface AuthenticationService {

	public boolean addContact(User user);
    public void checkAuthorization(String login, String password);
    public boolean userNotExists(String login, String password, String email);

}
