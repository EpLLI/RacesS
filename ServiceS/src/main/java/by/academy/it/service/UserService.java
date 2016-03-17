package by.academy.it.service;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.academy.it.Dao.Dao.DaoBets;
import by.academy.it.Dao.Dao.DaoRace;
import by.academy.it.pojos.Bets;
import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Race;


//@Service
//@Transactional(propagation = Propagation.REQUIRED)
public class UserService extends BaseService<Bets> implements IUserService{
	private static Logger log = Logger.getLogger(UserService.class);
	@Autowired
	private DaoBets daoBetsImpl;
	public List<Bets> getUseeBets()  {
		List<Bets> bet = null;

		try {
			bet =daoBetsImpl.getUseeBets();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return bet;
	}
	/*public Coefficient getBetsss(int id)  {
		Coefficient bet = null;
		bet = .getBets(id);
		return bet;
	}*/
	
	
	public List<Bets> getAllBets(int id_client)  {
		List<Bets> bet = null;
		try {
			bet = daoBetsImpl.getAllBets(id_client);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bet;
	}
	
	public void addBet(Bets bets) {
		 
		try {
			daoBetsImpl.addBets(bets);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
