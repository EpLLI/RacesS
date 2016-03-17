package by.academy.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.it.Dao.Dao.UserDao;
import by.academy.it.pojos.User;
@Service
@Transactional
public class LoginService implements ILoginService{
	@Autowired
	private UserDao dao;
	@Override
	public User findById(int id) {
		return dao.getUserById(id);
		
	}

	@Override
	public User findByUserName(String username) {
		
		return dao.findByUserName(username);
	}

}
