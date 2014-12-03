package services;

import java.util.List;

import javax.ejb.Remote;

import domain.Mark;

@Remote
public interface CarService {

	int getCarCount();
	List<Mark> getCars(int offset, int count);
}
