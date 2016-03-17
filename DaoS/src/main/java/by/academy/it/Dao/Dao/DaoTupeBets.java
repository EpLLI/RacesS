package by.academy.it.Dao.Dao;

import java.util.List;

import javax.naming.NamingException;


import by.academy.it.pojos.Tupebets;

public interface DaoTupeBets extends Dao<Tupebets>{
	List<Tupebets> getAllTupeBets() throws NamingException;

	String getTupeBets(int id) throws NamingException;
	}

