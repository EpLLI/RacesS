package by.academy.it.service;

import by.academy.it.pojos.User;

public interface ILoginService {
	User findById(int id);

	User findByUserName(String username);
}
