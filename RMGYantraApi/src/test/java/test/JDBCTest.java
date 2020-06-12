package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class JDBCTest {

	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.deregisterDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		String query="select * from project";
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getInt(6));
		}
		con.close();
	}
}
