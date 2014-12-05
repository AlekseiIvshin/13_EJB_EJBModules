package services;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.User;

@Stateful
public class AccountServiceBean implements AccountService {

	private final static Logger logger = LoggerFactory
			.getLogger(AccountServiceBean.class);
	
	private User user;

	@PostConstruct
	void init() {
		logger.info("Construct account service");
		user = null;
	}

	@Override
	public void login(User user) {
		logger.info("Login");
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void logout() {
		logger.info("Logout");
		user = null;
	}

}
