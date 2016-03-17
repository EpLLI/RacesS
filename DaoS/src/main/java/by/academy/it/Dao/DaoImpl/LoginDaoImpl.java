package by.academy.it.Dao.DaoImpl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.academy.it.Dao.Dao.UserDao;
import by.academy.it.Heberneit.HibernateUtil;
import by.academy.it.pojos.Race;
import by.academy.it.pojos.User;

@Repository
public class LoginDaoImpl extends BaseDao<User>implements UserDao {
	
	
	@Autowired
	public LoginDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	

	@Override
	public User getUserById(int id) {
		User user = null;

		String hql = "select u from User u where u.id = :id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		user = (User) query.uniqueResult();

		return user;
	}

	@Override
	public User findByUserName(String username) {
		User user = null;

		String hql = "select u from User u where u.username = :username";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		user = (User) query.uniqueResult();

		return user;
	}

}
