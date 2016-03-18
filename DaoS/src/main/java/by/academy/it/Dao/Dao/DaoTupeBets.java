package by.academy.it.Dao.Dao;

import java.util.List;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Tupebets;

public interface DaoTupeBets extends Dao<Tupebets>{
	List<Tupebets> getAllTupeBets() throws DaoException;

	String getTupeBets(int id) throws DaoException;
	}

