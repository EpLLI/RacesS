package by.academy.it.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import by.academy.it.pojos.Race;

public interface IAdminService extends Services<Race>{
	 void addRace(Race race) throws NamingException, SQLException;

	 void addRaceCoef(Race race) throws NamingException, SQLException;

	 void updateRace(Race race) throws NamingException;


	List<Race> get(Integer offset, Integer maxResults);

	Long count();
}
