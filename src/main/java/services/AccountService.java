package services;

import javax.ejb.Remote;

import domain.User;

@Remote
public interface AccountService {

	void login(User user);

	User getUser();

	void logout();
}
