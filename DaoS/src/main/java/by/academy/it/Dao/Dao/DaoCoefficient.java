package by.academy.it.Dao.Dao;

import java.util.List;

import javax.naming.NamingException;

import by.academy.it.pojos.Coefficient;


public interface DaoCoefficient extends Dao<Coefficient> {
	List<Coefficient> getAllCoefficiet() throws NamingException;

	boolean addCoefficient(Coefficient coefficient) throws NamingException;

}
