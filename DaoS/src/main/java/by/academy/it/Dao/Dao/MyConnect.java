package by.academy.it.Dao.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyConnect {

		private Connection myConnection;



		public Connection MyConnection() {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ResourceBundle resource = ResourceBundle.getBundle(".config");
			String url = resource.getString("db.url");
			String user = resource.getString("db.user");
			String pass = resource.getString("db.password");
			try {
				myConnection = ((Connection) DriverManager.getConnection(url, user, pass));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return myConnection;
		}
		public Connection getMyConnection()  {
			return MyConnection();
		}
	



}
