package by.academy.it.Dao.Dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import by.academy.it.pojos.Race;

public interface DaoRace extends Dao<Race> {

	boolean updateRace(Race race) throws NamingException;

	void saveOrUpdate(Race race) throws NamingException, SQLException;

	void save(Race race) throws NamingException, SQLException;

	List<Race> get(Integer offset, Integer maxResults);

	Long count();
}
