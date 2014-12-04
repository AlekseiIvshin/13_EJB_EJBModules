package services;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

import domain.User;

@Stateful
public class AccountServiceBean implements AccountService {

	private User user;

	@PostConstruct
	void init() {
		System.out.println("Constract account service");
		user = null;
	}

	@Override
	public void login(User user) {
		System.out.println("Login");
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void logout() {
		System.out.println("Logout");
		user = null;
	}

}
