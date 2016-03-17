package by.academy.it.service;


import java.util.List;

import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Tupebets;

public interface IBucmekService extends Services<Tupebets>{
	public List<Tupebets> getAllTupeBets() ;
	public void addCoefficient(Coefficient coefficient) ;
	public List<Coefficient> getAllCoefficiet();
}
