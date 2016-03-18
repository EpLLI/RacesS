package by.academy.it.service;


import java.util.List;

import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Tupebets;
import by.academy.it.serviceException.ServiceException;

public interface IBucmekService extends Services<Tupebets>{
	public List<Tupebets> getAllTupeBets() throws ServiceException; ;
	public void addCoefficient(Coefficient coefficient) throws ServiceException;;
	public List<Coefficient> getAllCoefficiet()throws ServiceException;;
}
