package dao;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.ejb3.annotation.Cache;

import domain.Mark;
import domain.Mark_;

@Local
@Stateless
public class CarDAOBean implements CarDAO {

	@PersistenceContext(unitName = "EProjectEJB")
	EntityManager entityManager;

	@Override
	public int getCount() throws SQLException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<Mark> mark = query.from(Mark.class);
		query.select(builder.count(mark));
		query.where(builder.equal(mark.get(Mark_.deleted), 0));
		
		return entityManager.createQuery(query)
				.getSingleResult().intValue();
	}

	@Override
	public List<Mark> getMarks(int offset, int count) throws SQLException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Mark> query = builder.createQuery(Mark.class);
		Root<Mark> mark = query.from(Mark.class);
		query.select(mark);
		query.where(builder.equal(mark.get(Mark_.deleted), 0));
		return entityManager.createQuery(query.select(mark))
				.setMaxResults(count).setFirstResult(offset).getResultList();
	}

	@Override
	public Mark get(long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Mark> query = builder.createQuery(Mark.class);
		Root<Mark> mark = query.from(Mark.class);
		query.select(mark);
		query.where(builder.equal(mark.get(Mark_.id), id));
		return entityManager.createQuery(query.select(mark))
				.getSingleResult();
	}

	@Override
	public void create(Mark mark) {
		entityManager.persist(mark);
	}

	@Override
	public void delete(long id) {
		Mark m = entityManager.find(Mark.class, id, LockModeType.OPTIMISTIC);
		if(m!=null){
			m.setDeleted(1);
			entityManager.persist(m);
		}
	}

}
