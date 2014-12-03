package hello;

import java.sql.SQLException;

import javax.ejb.Local;

@Local
public interface HelloDAO {

	int getCount() throws SQLException;
}
