package dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Mark;

@Local
@Stateless
public class CarDAOBeanJPA implements CarDAO {

	// @PersistenceContext
	// EntityManagerFactory emf;
	@PersistenceContext(unitName = "EProjectEJB")
	EntityManager entityManager;

	@Override
	public int getCount() throws SQLException {
		// entityManager = emf.createEntityManager();
		return ((Long) entityManager.createQuery("SELECT COUNT(m) FROM Mark m")
				.getSingleResult()).intValue();
	}

	@Override
	public List<Mark> getMarks(int offset, int count) throws SQLException {
		// entityManager = emf.createEntityManager();
		return entityManager.createQuery("SELECT m FROM Mark m")
				.setMaxResults(count).setFirstResult(offset).getResultList();
	}

	@Override
	public Mark get(long id) {
		return (Mark) entityManager
				.createQuery("SELECT m FROM Mark m WHERE m.id_car_mark=:id")
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public void create(Mark mark) {
		entityManager.persist(mark);
	}

	@Override
	public void delete(long id) {
		Mark m = entityManager.find(Mark.class, id);
		if(m!=null){
			m.setDeleted(1);
			entityManager.persist(m);
		}
	}

}
