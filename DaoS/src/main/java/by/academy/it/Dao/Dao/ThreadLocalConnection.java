package by.academy.it.Dao.Dao;

import java.sql.Connection;
import java.sql.SQLException;


public class ThreadLocalConnection {
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			return (Connection) new MyConnect().getMyConnection();
		}
	};

	public static Connection getConnection() {
		return connectionHolder.get();
	}
	
	public static void removeConnection() {
		connectionHolder.remove();
		
	}
}
