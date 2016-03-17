package by.academy.it.Dao.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connect {
	private static Connect instance;

	Connect() {
	}

	public static Connect getInstance() {
		if (instance == null) {
			instance = new Connect();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		ResourceBundle resource = ResourceBundle.getBundle(".config");
		String url = resource.getString("db.url");
		String user = resource.getString("db.user");
		String pass = resource.getString("db.password");
		return DriverManager.getConnection(url, user, pass);
	}
	
	public Connection getMyConnection() throws SQLException {
		return getConnection();
	}
	
}