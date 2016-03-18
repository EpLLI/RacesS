package by.academy.it.Dao.Dao;


import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.User;

public interface UserDao {

	public User getUserById(int id) throws DaoException;

	User findByUserName(String username) throws DaoException;

}