package services;

import java.util.List;

import javax.ejb.Remote;

import domain.Mark;

@Remote
public interface CarService {

	int getCarCount();

	List<Mark> getCars(int offset, int count);

	Mark getMark(long id);

	void createMark(Mark mark);
}
