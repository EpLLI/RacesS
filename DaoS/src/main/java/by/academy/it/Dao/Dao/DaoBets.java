package by.academy.it.Dao.Dao;

import java.util.List;

import javax.naming.NamingException;

import by.academy.it.pojos.Bets;
import by.academy.it.pojos.Race;


public interface DaoBets extends Dao<Bets> {
	List<Bets> getAllBets(int id_client) throws NamingException;

	List<Bets> getUseeBets() throws NamingException;

	boolean addBets(Bets bets) throws NamingException;
}
