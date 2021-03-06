package by.academy.it.Dao.DaoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.academy.it.Dao.Dao.DaoRace;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Race;

@Repository()
public class DaoRaceIml extends BaseDao<Race>implements DaoRace {
	@Autowired
	public DaoRaceIml(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	private Logger log = Logger.getLogger(DaoRaceIml.class);

	@Override
	public void saveOrUpdate(Race race) throws DaoException {
		try {
			getSession().saveOrUpdate(race);
			getSession().update(race);
			getSession().flush();
		} catch (HibernateException e) {

			log.error("Error saveorUpdate in Dao" + e);
			throw new DaoException(e);
		}

	}

	@Override
	public void save(Race race) throws DaoException {
		try {
			getSession().saveOrUpdate(race);
			Coefficient coef = new Coefficient(1, 1);
			Coefficient coef2 = new Coefficient(2, 1);
			Coefficient coef3 = new Coefficient(3, 1);
			coef.setRace(race);
			coef2.setRace(race);
			coef3.setRace(race);
			getSession().saveOrUpdate(coef);
			getSession().saveOrUpdate(coef2);
			getSession().saveOrUpdate(coef3);
			getSession().flush();
		} catch (HibernateException e) {
			// transaction.rollback();
			log.error("Error save in Dao" + e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<Race> get(Integer offset, Integer maxResults) throws DaoException {

		return getSession().createCriteria(Race.class).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10).list();

	}

	@Override
	public boolean updateRace(Race race) throws DaoException {
		boolean flag = false;
		try {
			String hql = "UPDATE Race set result=:result " + "WHERE id_race=:id_race";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("result", race.getResult());
			query.setParameter("id_race", race.getId_race());
			query.executeUpdate();
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error update  in Dao" + e);
			throw new DaoException(e);
		}
		return flag;

	}

	@Override
	public Long count() {
		return (Long) getSession().createCriteria(Race.class).setProjection(Projections.rowCount()).uniqueResult();
	}
}
