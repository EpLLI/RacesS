package by.academy.it.Dao.DaoImpl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.academy.it.Dao.Dao.DaoCoefficient;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Coefficient;


@Repository()
public class DaoCoefficientImpl extends BaseDao<Coefficient>implements DaoCoefficient {
	@Autowired
	public DaoCoefficientImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	private Logger log = Logger.getLogger(DaoCoefficientImpl.class);

	@Override
	public List<Coefficient> getAllCoefficiet()  throws DaoException{
		List<Coefficient> result = null;
		try {

			String hql = "FROM Coefficient";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {

			log.error("Error getAllCieff in Dao" + e);
			throw new DaoException(e);
		}
		return result;
	}


	@Override
	public boolean addCoefficient(Coefficient coefficient)  throws DaoException{
		boolean flag = false;
		try {

			String hql = "UPDATE Coefficient set coeff=:coeff " + "WHERE id=:id";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("coeff", coefficient.getCoeff());
			query.setParameter("id", coefficient.getId());

			query.executeUpdate();
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error addCoeff  in Dao" + e);
			throw new DaoException(e);
		}

		return flag;

	}
}
