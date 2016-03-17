package by.academy.it.service;



import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.academy.it.Dao.Dao.DaoCoefficient;
import by.academy.it.Dao.Dao.DaoTupeBets;
import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Tupebets;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BucmekService extends BaseService<Tupebets> implements IBucmekService  {
	
private static Logger log = Logger.getLogger(AdminService.class);
	
	@Autowired
	private DaoTupeBets daoTupeBetsImpl;
	
	@Autowired
	private DaoCoefficient daoCoefficien;

	public BucmekService() {
	
	}
	public void addCoefficient(Coefficient coefficient){
		 
		try {
			daoCoefficien.addCoefficient(coefficient);
		} catch (NamingException e) {

			e.printStackTrace();
		}
	}
	public List<Coefficient> getAllCoefficiet() {

		List<Coefficient>  coeff = null;

		try {
			coeff = daoCoefficien.getAllCoefficiet();
		} catch (NamingException e) {

			e.printStackTrace();
		}
		return coeff;
	}
	public List<Tupebets> getAllTupeBets() {
		List<Tupebets>  tupbet = null;
		try {
			tupbet =daoTupeBetsImpl.getAllTupeBets() ;
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return tupbet;
	}

}
