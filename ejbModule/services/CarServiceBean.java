package services;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.CarDAO;
import domain.Mark;

@Remote
@Stateless
public class CarServiceBean implements CarService {

	@EJB
	CarDAO carDAO;
	
	@Override
	public int getCarCount() {
		try {
			return carDAO.getCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Mark> getCars(int offset, int count) {
		try {
			return carDAO.getMarks(offset, count);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


}
