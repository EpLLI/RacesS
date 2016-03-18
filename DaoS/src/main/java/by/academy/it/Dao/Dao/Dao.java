package by.academy.it.Dao.Dao;

import by.academy.it.DaoException.DaoException;

public interface Dao <T> {
	public T getById(Long id) throws DaoException;
	public void add(T model)throws DaoException;
	public void update(T model)throws DaoException;
	public void remove (Long id)throws DaoException;
	public void remove (T model)throws DaoException;
}
