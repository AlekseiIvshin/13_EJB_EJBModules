package hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Local
@Stateless
public class HelloDAOImpl implements HelloDAO {

	@Resource(mappedName = "java:jboss/datasources/AutoShow")
	DataSource dataSource;

	@Override
	public int getCount() throws SQLException {
		int res = -1;

		try (Connection connection = dataSource.getConnection()) {
			try (PreparedStatement ps = connection
					.prepareStatement("SELECT COUNT(id_customer) FROM auto_show.customer;")) {
				try (ResultSet resultSet = ps.executeQuery()) {
					if (resultSet.next()) {
						res = resultSet.getInt(1);
					}
				}
			}
		}
		return res;
	}

}
