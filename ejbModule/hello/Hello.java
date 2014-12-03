package hello;

import javax.ejb.Local;

@Local
public interface Hello {

	String sayHi(String name);
}
