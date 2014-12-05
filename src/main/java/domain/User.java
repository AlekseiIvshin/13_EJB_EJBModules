package domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5766879257046626986L;

	private final String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
