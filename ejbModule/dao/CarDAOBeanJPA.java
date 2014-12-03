package dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import domain.Mark;

@Local
@Stateless
public class CarDAOBeanJPA implements CarDAO {

//	@PersistenceContext
//	EntityManagerFactory emf;
	@PersistenceContext(unitName="autoshow")
	EntityManager entityManager;

	@Override
	public int getCount() throws SQLException {
		//entityManager = emf.createEntityManager();
		return ((Integer)entityManager.createQuery("SELECT COUNT(m) FROM MarkEntity m WHERE m.deleted = 0").getSingleResult());
	}

	@Override
	public List<Mark> getMarks(int offset, int count) throws SQLException {
		//entityManager = emf.createEntityManager();
		return entityManager
				.createQuery("SELECT m FROM MarkEntity m WHERE m.deleted = 0")
				.setMaxResults(count).setFirstResult(offset).getResultList();
	}

}
