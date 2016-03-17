package by.academy.it.Dao.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import by.academy.it.Dao.Dao.Connect;
import by.academy.it.Dao.Dao.DaoBets;
import by.academy.it.Hiberneit.HibernateUtil;
import by.academy.it.pojos.Bets;
import by.academy.it.pojos.Coefficient;
import by.academy.it.pojos.Race;



//@Repository()
public class DaoBetsImpl extends BaseDao<Bets> implements DaoBets {
	public static Connect con = Connect.getInstance();
	private Logger log = Logger.getLogger(DaoRaceIml.class);
	public DaoBetsImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		
	}
	@Override
	public List<Bets> getAllBets(int id_client) {
		List<Bets> result=null;		
		String hql = "Select B FROM Bets B where B.id_client=:id_client";		
		Query query = getSession().createQuery(hql);
		query.setParameter("id_client", id_client);
		 result = query.list();	
		return result;
	}
	@Override
	public List<Bets> getUseeBets() throws NamingException {
		List<Bets> betsss = new ArrayList<Bets>();
		try {
			Connection conn = con.getConnection();
			String template = "SELECT id, race, tupe_bets, coeff FROM tupebets inner join coefficient using(id_bets) inner join race using (id_race);";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(template);

			while (result.next()) {
				Bets bet = new Bets();
				bet.setId(result.getInt("id"));
				bet.setRace(result.getString("race"));
				bet.setTupe_bets(result.getString("tupe_bets"));
				bet.setCoeff(result.getDouble("coeff"));
				betsss.add(bet);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			log.error("Error SQL query", e);
		}

		return betsss;

	}
	public Coefficient getBets(int id) throws NamingException {
		
		Coefficient coeff=null;
		try {

    		String hql="Select c FROM Coefficient c where c.id=:id";
    		
            Query query=getSession().createQuery(hql);

			query.setParameter("id", id);
			coeff=(Coefficient) query.uniqueResult();
		} catch (HibernateException e) {
	        log.error("Error  in Dao" + e);

	    }	
		return coeff;
	}
	
	@Override
	public boolean addBets(Bets bet) throws NamingException {
		boolean flag = false;
		try {

			getSession().saveOrUpdate(bet);
			getSession().update(bet);

		} catch (HibernateException e) {

	        log.error("Error  in Dao" + e);

	    }

		return flag;

	}
	


}
