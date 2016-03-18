package by.academy.it.service;

import java.util.List;



import by.academy.it.pojos.Race;
import by.academy.it.serviceException.ServiceException;

public interface IAdminService extends Services<Race>{
	 void addRace(Race race) throws ServiceException;

	 void addRaceCoef(Race race) throws ServiceException;

	 void updateRace(Race race) throws ServiceException;


	List<Race> get(Integer offset, Integer maxResults)throws ServiceException;

	Long count()throws ServiceException;
}
