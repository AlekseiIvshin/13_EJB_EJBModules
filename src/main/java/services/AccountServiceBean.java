package services;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

import domain.User;

@Stateful
public class AccountServiceBean implements AccountService {

	private User user;
	
	@PostConstruct
	void init(){
		user = null;
	}
	
	@Override
	public void login(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

}
