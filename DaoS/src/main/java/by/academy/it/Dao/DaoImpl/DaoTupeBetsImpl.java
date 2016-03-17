package by.academy.it.Dao.DaoImpl;

import java.util.List;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.academy.it.Dao.Dao.DaoTupeBets;
import by.academy.it.pojos.Tupebets;

@Repository()
public class DaoTupeBetsImpl extends BaseDao<Tupebets>implements DaoTupeBets {
	private Logger log = Logger.getLogger(DaoTupeBetsImpl.class);

	@Autowired
	public DaoTupeBetsImpl(SessionFactory sessionFactory) {
		super(sessionFactory);

	}

	@Override
	public List<Tupebets> getAllTupeBets() throws NamingException {
		List<Tupebets> result = null;
		try {
			String hql = "FROM Tupebets";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {
			log.error("Error  in Dao" + e);
		}
		return result;

	}

	@Override
	public String getTupeBets(int id) throws NamingException {
		String result = null;
		try {
			String hql = "Select T.tupe_bets FROM Tupebets T where T.id=:id";
			Query query = getSession().createQuery(hql);
			query.setParameter("id", id);
			result = (String) query.uniqueResult();
		} catch (HibernateException e) {			
			log.error("Error  in Dao" + e);
		}
		return result;
	}

}
