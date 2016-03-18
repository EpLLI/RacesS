package by.academy.it.service;

import by.academy.it.serviceException.ServiceException;

public interface Services<T> {
	T getById(Long id) throws ServiceException;

	void add(T model) throws ServiceException;

	void update(T model) throws ServiceException;

	void remove(Long id) throws ServiceException;

	void remove(T model) throws ServiceException;

}
