package by.academy.it.serviceImpl;


import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.annotation.Propagation;
import by.academy.it.Dao.Dao.DaoRace;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Race;
import by.academy.it.service.IAdminService;
import by.academy.it.serviceException.ServiceException;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminService extends BaseService<Race> implements IAdminService {
	private static Logger log = Logger.getLogger(AdminService.class);
	
	@Autowired
	private DaoRace daoRaceIml;
	


	public AdminService() {
	
	}


	@Override
	public void addRace(Race race) throws ServiceException{ 
		try {
		daoRaceIml.saveOrUpdate( race);
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}
	}


	@Override
	public void addRaceCoef(Race race) throws ServiceException{ 
		try {
		daoRaceIml.save(race);
		} catch (DaoException e) {
			log.error("Error in addRaceCoef process --- " + e);
			throw new ServiceException(e);
		}
	}		


	@Override
	public void updateRace(Race race) throws ServiceException{
		 try{
		daoRaceIml.updateRace( race);
	} catch (DaoException e) {
		log.error("Error in updateRce process --- " + e);
		throw new ServiceException(e);
	}
	}

	@Override
	 public  List<Race> get(Integer offset, Integer maxResults) throws ServiceException  {
		 
		try {
			return daoRaceIml.get(offset,maxResults);
		} catch (DaoException e) {
			log.error("Error in get process --- " + e);
			throw new ServiceException(e);
		}}
	
	@Override
	public Long count() throws ServiceException {
		try {
		return daoRaceIml.count();
		} catch (DaoException e) {
			log.error("Error in count process --- " + e);
			throw new ServiceException(e);
		}}



}
