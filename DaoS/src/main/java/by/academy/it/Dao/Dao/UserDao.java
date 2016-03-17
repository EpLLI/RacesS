package by.academy.it.Dao.Dao;

import javax.naming.NamingException;

import by.academy.it.pojos.User;

public interface UserDao {

	public User getUserById(int id);

	User findByUserName(String username);

}