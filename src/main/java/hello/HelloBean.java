package hello;

import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Local
@Stateless
public class HelloBean implements Hello {


	@EJB
	HelloDAO helloDao;
	
	/**
	 * Default constructor.
	 */
	public HelloBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Hello#sayHi(String)
	 */
	public String sayHi(String name) {
		int userCount = -1;
		try {
			userCount = helloDao.getCount();
			return "Hello, " + name+"! Count of user = "+userCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(userCount);
		return "Hello, " + name+"! I can't get user count!";
	}

}
