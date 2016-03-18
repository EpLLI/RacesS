package by.academy.it.service;

import by.academy.it.pojos.User;
import by.academy.it.serviceException.ServiceException;

public interface ILoginService {
	User findById(int id)throws ServiceException;

	User findByUserName(String username)throws ServiceException;
}
