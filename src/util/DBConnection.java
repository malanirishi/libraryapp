package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBConnection {
	private static Connection connection;
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException{
		if(connection==null)
		{
			/*Class.forName("oracle.jdbc.driver.OracleDriver"); //Load and Register Driver with db
			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","Oracle012");
			System.out.println("Connection Successfull");	*/
			ResourceBundle bun = ResourceBundle.getBundle("bankdbconfig");
			Class.forName(bun.getString("driver"));
			connection = DriverManager.getConnection(bun.getString("url"),bun.getString("user"),bun.getString("password"));
			System.out.println("Connection Successfull");
		}
		
		return connection;
	}
	
	public static void closeConnection() throws SQLException{
		if(connection!=null){
			connection.close();
			connection=null;	
		}
		
	}
	
}
