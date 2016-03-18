package by.academy.it.Dao.Dao;


import java.util.List;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Race;

public interface DaoRace extends Dao<Race> {

	boolean updateRace(Race race) throws DaoException;

	void saveOrUpdate(Race race) throws DaoException;

	void save(Race race) throws DaoException;

	List<Race> get(Integer offset, Integer maxResults) throws DaoException;

	Long count() throws DaoException;
}
