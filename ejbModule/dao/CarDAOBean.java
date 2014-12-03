package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import domain.Mark;


public class CarDAOBean 
//implements CarDAO 
{

	@Resource(mappedName = "java:jboss/datasources/AutoShow")
	DataSource dataSource;

//	@Override
	public int getCount() throws SQLException {
		int res = -1;

		try (Connection connection = dataSource.getConnection()) {
			try (PreparedStatement ps = connection
					.prepareStatement("SELECT COUNT(id_car_mark) FROM auto_show.car_mark;")) {
				try (ResultSet resultSet = ps.executeQuery()) {
					if (resultSet.next()) {
						res = resultSet.getInt(1);
					}
				}
			}
		}
		return res;
	}

//	@Override
	public List<Mark> getMarks(int offset, int count) throws SQLException {
		List<Mark> result = new ArrayList<Mark>();

		try (Connection connection = dataSource.getConnection()) {
			try (PreparedStatement ps = connection
					.prepareStatement("SELECT id_car_mark,name FROM auto_show.car_mark WHERE deleted=0 LIMIT "
							+ count + " OFFSET " + offset + ";")) {
				try (ResultSet resultSet = ps.executeQuery()) {
					while (resultSet.next()) {
						int id = resultSet.getInt("id_car_mark");
						String name = resultSet.getString("name");
						result.add(new Mark(id, name));
					}
				}
			}
		}
		return result;
	}

}
