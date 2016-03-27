import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mypack.Account;
import util.DBConnection;


public class CustomerDAO {

	public boolean validateCustomer(String uname, String pass) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.openConnection();
		
		PreparedStatement pstm = conn.prepareStatement("select * from customer where uname=? and password=?");
		pstm.setString(1,uname);
		pstm.setString(2,pass);
		int rowsAffected = pstm.executeUpdate();
		DBConnection.closeConnection();
		if(rowsAffected==0)
			return false;
		else
			return true;

	}

	public ArrayList<Account> viewAccountDetails(String uname) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.openConnection();
		ArrayList<Account> accountlist= new ArrayList<Account>();
		PreparedStatement pstm = conn.prepareStatement("select * from accounts where uname= ?");
		pstm.setString(1,uname);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next())
		{
		Account account = new Account(rs.getInt(1), rs.getString(2),rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
		accountlist.add(account);
		}
		DBConnection.closeConnection();
		return accountlist;
	}

	public Account getAccount(int selaccno) throws SQLException, ClassNotFoundException {
		Connection conn = DBConnection.openConnection();
		PreparedStatement pstm = conn.prepareStatement("select * from accounts where account_no= ?");
		pstm.setInt(1,selaccno);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		Account account = new Account(rs.getInt(1), rs.getString(2),rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
		
	
		DBConnection.closeConnection();
	
		return account;
	}
	
	
	
	/*public CustomerAccount viewPersonalDetails(String uname) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.openConnection();
		PreparedStatement ps= conn.prepareStatement("SELECT * FROM customer JOIN accounts ON customer.uname = accounts.uname where customer.uname=?");
		ps.setString(1, uname);
		ResultSet rs= rs.next();
			CustomerAccount customerAccount = new CustomerAccount(rs.getString(1), rs.getString(2),  rs.getInt(7), rs.getInt(10),rs.getDouble(13), rs.getString(4));

		return customerAccount;
		
	}*/

}
