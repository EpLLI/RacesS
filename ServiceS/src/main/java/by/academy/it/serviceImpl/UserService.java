package by.academy.it.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import by.academy.it.Dao.Dao.DaoBets;
import by.academy.it.DaoException.DaoException;
import by.academy.it.pojos.Bets;

import by.academy.it.service.IUserService;
import by.academy.it.serviceException.ServiceException;

//@Service
//@Transactional(propagation = Propagation.REQUIRED)
public class UserService extends BaseService<Bets>implements IUserService {
	private static Logger log = Logger.getLogger(UserService.class);
	@Autowired
	private DaoBets daoBetsImpl;

	public List<Bets> getUseeBets() throws ServiceException {
		List<Bets> bet = null;

		try {
			bet = daoBetsImpl.getUseeBets();
		} catch (DaoException e) {
			log.error("Error in getUseeBets process --- " + e);
			throw new ServiceException(e);
		}

		return bet;
	}

	public List<Bets> getAllBets(int id_client) throws ServiceException {
		List<Bets> bet = null;
		try {
			bet = daoBetsImpl.getAllBets(id_client);
		} catch (DaoException e) {
			log.error("Error in getAllBet process --- " + e);
			throw new ServiceException(e);
		}
		return bet;
	}

	public void addBet(Bets bets) throws ServiceException {

		try {
			daoBetsImpl.addBets(bets);
		} catch (DaoException e) {
			log.error("Error in addBet process --- " + e);
			throw new ServiceException(e);
		}
	}

}
