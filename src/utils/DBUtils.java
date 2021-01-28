package utils;

import java.sql.*;

public interface DBUtils {
	
	static Connection fetchDBConnection() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/acts?useSSL=false";
		return DriverManager.getConnection(url, "root", "Oggyoggy@1");
	}

}
