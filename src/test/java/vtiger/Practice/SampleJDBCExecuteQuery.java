package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable {

		// Get Driver from MySql jar and register this in driver manager
		Driver driverRef = new Driver();
		
		// Step 1 : Register the Driver
		DriverManager.registerDriver(driverRef);
		
		// Step 2 : Get the connection with driver -provide DB Name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root" );
		
		// Step 3 : Issue create statement
		Statement state = con.createStatement();
		
		// Step 4 : Execute the query - provide table name
		String query = "insert into sampletable values('hulk', 5, 'california');";
		int result = state.executeUpdate(query);
//		ResultSet result = state.executeQuery("select * from sampletable;");
//		while(result.next())
//		{
//			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
//		}
		
		
		// Validate
		if(result==1)
		{
			System.out.println("Data Added");
		}
		else {
			System.out.println("Data not Added");
		}
		
		ResultSet res = state.executeQuery("select * from sampletable;");
		while(res.next())
		{
			System.out.println(res.getString(1));
		}
		
		// Step 5 : Close the DB
		con.close();
		
	}

}
