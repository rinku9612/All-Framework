package rmgyantra.genericlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.gjt.mm.mysql.Driver;

public class DbUtilities {
	static Connection con = null;
	static ResultSet result = null;

	public static void connectToDB() {
		Driver driverRef;
		try {
			driverRef=new Driver() ;
			DriverManager.registerDriver(driverRef);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
	public static ResultSet executeQuery(String query) {
		try {
			result=con.createStatement().executeQuery(query);
		return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public static void closeDb() throws SQLException {
		con.close();
	}
}
