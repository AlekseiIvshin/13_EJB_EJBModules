package services;

import javax.ejb.Remote;
import javax.enterprise.context.SessionScoped;

import domain.User;


@Remote
public interface AccountService {

	void login(User user);
	User getUser();
}
