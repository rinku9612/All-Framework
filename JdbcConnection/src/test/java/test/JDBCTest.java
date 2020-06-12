package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "admin");
		Statement stmt=con.createStatement();
		String query="select * from actor";
		ResultSet resultset = stmt.executeQuery(query);
		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3)+" "+resultset.getString(4));
		}
con.close();
	}

}
