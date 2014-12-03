package dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import domain.Mark;

@Local
public interface CarDAO {

	int getCount() throws SQLException;
	List<Mark> getMarks(int offset, int count) throws SQLException;
}
