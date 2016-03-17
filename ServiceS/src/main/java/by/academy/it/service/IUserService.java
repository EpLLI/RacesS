package by.academy.it.service;

import java.util.List;

import by.academy.it.pojos.Bets;
import by.academy.it.pojos.Coefficient;



public interface IUserService extends Services<Bets> {
	
	public List<Bets> getAllBets(int id_client);
	//public Coefficient getBetsss(int id);
	public List<Bets> getUseeBets();
	public void addBet(Bets bets);
}
