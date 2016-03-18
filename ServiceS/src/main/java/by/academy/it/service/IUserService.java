package by.academy.it.service;

import java.util.List;

import by.academy.it.pojos.Bets;
import by.academy.it.serviceException.ServiceException;

public interface IUserService extends Services<Bets> {

	public List<Bets> getAllBets(int id_client) throws ServiceException;

	public List<Bets> getUseeBets() throws ServiceException;

	public void addBet(Bets bets) throws ServiceException;
}
