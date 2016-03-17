package by.academy.it.Heberneit;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil  {
	private static HibernateUtil util = null;

	private static Logger log = Logger.getLogger(HibernateUtil.class);

	private SessionFactory sessionFactory = null;

	private final ThreadLocal sessions = new ThreadLocal();

	private HibernateUtil() {
	    try {
	    	Configuration conf=new Configuration();
	conf.setNamingStrategy(new CustomNamingStrategy());
	    	
	        sessionFactory =conf.configure().buildSessionFactory();
	    } catch (Throwable ex) {
	        log.error("Initial SessionFactory creation failed." + ex);
	        System.exit(0);
	    }
	}

	public Session getSession () {
	    Session session = (Session) sessions.get();
	    if (session == null) {
	        session = sessionFactory.openSession();
	        sessions.set(session);
	    }

	    return session;
	}

	public static synchronized HibernateUtil getHibernateUtil(){
	    if (util == null){
	        util = new HibernateUtil();
	    }
	    return util;
	}



}
