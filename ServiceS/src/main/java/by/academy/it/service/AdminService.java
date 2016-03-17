package by.academy.it.service;


import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.annotation.Propagation;
import by.academy.it.Dao.Dao.DaoRace;

import by.academy.it.pojos.Race;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminService extends BaseService<Race> implements IAdminService {
	private static Logger log = Logger.getLogger(AdminService.class);
	
	@Autowired
	private DaoRace daoRaceIml;
	


	public AdminService() {
	
	}


	@Override
	public void addRace(Race race) throws NamingException, SQLException{ 
		daoRaceIml.saveOrUpdate( race);
	}


	@Override
	public void addRaceCoef(Race race) throws NamingException, SQLException{ 
		daoRaceIml.save(race);
	}		


	@Override
	public void updateRace(Race race) throws NamingException{
		 
		daoRaceIml.updateRace( race);
	}

	@Override
	 public  List<Race> get(Integer offset, Integer maxResults)  {
		 
		return daoRaceIml.get(offset,maxResults);}
	
	@Override
	public Long count() {
		return daoRaceIml.count();
	}



}
