import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mypack.Account;
import mypack.Customer;
import mypack.CustomerAccount;
import util.DBConnection;

public class AdminDao {

	public boolean validateAdmin(String uname, String pass) {
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"E:/rm_workspace_luna/RMAS/src/SecuredAdmin"));
			String rightuname = br.readLine();
			String rightpwd = br.readLine();
			System.out.println(rightuname + " read " + rightpwd);
			if (uname.equals(rightuname) && pass.equals(rightpwd)) {
				return true;
			}

		} catch (IOException e) {
			System.out.println("Error!!!Unable to read from file..");
		}
		return false;
	}

	public int insertCustomer(Customer addcus) throws ClassNotFoundException,
			SQLException {

		Connection conn = DBConnection.openConnection();
		PreparedStatement pstm = conn
				.prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?)");
		pstm.setString(1, addcus.getUname());
		pstm.setString(2, addcus.getName());
		pstm.setString(3, addcus.getPassword());
		pstm.setString(4, addcus.getAddress());
		pstm.setString(5, addcus.getCity());
		pstm.setString(6, addcus.getState());
		pstm.setInt(7, addcus.getPinCode());
		pstm.setInt(8, addcus.getPhoneNumber());
		pstm.setString(9, addcus.getEmail());
		int rowsAffected = pstm.executeUpdate();
		DBConnection.closeConnection();
		return rowsAffected;

	}

	public ArrayList<Customer> viewCustomers() throws ClassNotFoundException,
			SQLException {
		Connection conn = DBConnection.openConnection();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("select * from customer");
		while (rs.next()) {
			Customer customer = new Customer(rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getInt(7), rs.getInt(8),
					rs.getString(9));
			customerList.add(customer);
		}

		return customerList;
	}

	public ArrayList<CustomerAccount> viewAllCustomersAccounts()
			throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.openConnection();
		ArrayList<CustomerAccount> customerAccountList = new ArrayList<CustomerAccount>();
		Statement stm = conn.createStatement();
		ResultSet rs = stm
				.executeQuery("SELECT * FROM customer JOIN accounts ON customer.uname = accounts.uname");
		while (rs.next()) {
			CustomerAccount customerAccounts = new CustomerAccount(
					rs.getString(1), rs.getString(2), rs.getInt(7),
					rs.getInt(10), rs.getDouble(13), rs.getString(4));
			customerAccountList.add(customerAccounts);
		}

		return customerAccountList;
	}

	public Customer searchCustomers(String username)
			throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.openConnection();
		PreparedStatement pstm = conn
				.prepareStatement("select * from customer where uname=?");
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		Customer customer = new Customer(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
		DBConnection.closeConnection();
		return customer;
	}

	public int insertAccount(Account account) throws ClassNotFoundException,
			SQLException {
		Connection conn = DBConnection.openConnection();
		PreparedStatement pstm = conn
				.prepareStatement("insert into accounts values (?,?,?,?,?,?,?,?)");
		pstm.setInt(1, account.getAccount_no());
		pstm.setString(2, account.getOpening_date());
		pstm.setDouble(3, account.getMin_bal());
		pstm.setDouble(4, account.getCurrent_bal());
		pstm.setDouble(5, account.getRate_of_intrest());
		pstm.setString(6, account.getAccount_type());
		pstm.setString(7, account.getUname());
		pstm.setDouble(8, account.getGetODlimit());
		int rowsAffected = pstm.executeUpdate();
		DBConnection.closeConnection();
		return rowsAffected;
	}

}
