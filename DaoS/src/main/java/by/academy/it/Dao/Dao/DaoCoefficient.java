package by.academy.it.Dao.Dao;

import java.util.List;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Coefficient;


public interface DaoCoefficient extends Dao<Coefficient> {
	List<Coefficient> getAllCoefficiet() throws DaoException;

	boolean addCoefficient(Coefficient coefficient) throws DaoException;

}
