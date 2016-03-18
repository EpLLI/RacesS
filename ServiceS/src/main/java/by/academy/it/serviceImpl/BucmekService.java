package by.academy.it.serviceImpl;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.academy.it.Dao.Dao.DaoCoefficient;
import by.academy.it.Dao.Dao.DaoTupeBets;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Tupebets;
import by.academy.it.service.IBucmekService;
import by.academy.it.serviceException.ServiceException;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BucmekService extends BaseService<Tupebets> implements IBucmekService  {
	
private static Logger log = Logger.getLogger(BucmekService.class);
	
	@Autowired
	private DaoTupeBets daoTupeBetsImpl;
	
	@Autowired
	private DaoCoefficient daoCoefficien;

	public BucmekService() {
	
	}
	public void addCoefficient(Coefficient coefficient) throws ServiceException{
		 
		try {
			daoCoefficien.addCoefficient(coefficient);
		} catch (DaoException e) {
			log.error("Error in addCoefficient process --- " + e);
			throw new ServiceException(e);
		}
	}
	public List<Coefficient> getAllCoefficiet() throws ServiceException {

		List<Coefficient>  coeff = null;

		try {
			coeff = daoCoefficien.getAllCoefficiet();
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return coeff;
	}
	public List<Tupebets> getAllTupeBets() throws ServiceException {
		List<Tupebets>  tupbet = null;
		try {
			tupbet =daoTupeBetsImpl.getAllTupeBets() ;
		} catch (DaoException e) {
			log.error("Error in getAllTupeBets process --- " + e);
			throw new ServiceException(e);
		}

		return tupbet;
	}

}
