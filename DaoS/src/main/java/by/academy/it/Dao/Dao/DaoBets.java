package by.academy.it.Dao.Dao;

import java.util.List;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Bets;


public interface DaoBets extends Dao<Bets> {
	List<Bets> getAllBets(int id_client) throws DaoException;

	List<Bets> getUseeBets() throws DaoException;

	boolean addBets(Bets bets) throws DaoException;
}
