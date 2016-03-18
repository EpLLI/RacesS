package by.academy.it.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.it.Dao.Dao.UserDao;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.User;
import by.academy.it.service.ILoginService;
import by.academy.it.serviceException.ServiceException;
@Service
@Transactional
public class LoginService implements ILoginService{
	private static Logger log = Logger.getLogger(LoginService.class);
	@Autowired
	private UserDao dao;
	@Override
	public User findById(int id) throws ServiceException {
		try{
		return dao.getUserById(id);
		} catch (DaoException e) {
			log.error("Error in findById process --- " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public User findByUserName(String username) throws ServiceException {
		try{
		return dao.findByUserName(username);
	} catch (DaoException e) {
		log.error("Error in findByUserName process --- " + e);
		throw new ServiceException(e);
	}
	}

}
