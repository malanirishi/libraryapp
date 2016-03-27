import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;


public class AccountDao {
	public int deposit(int selaccno, double amt)  throws ClassNotFoundException, SQLException
	{
		Connection conn = DBConnection.openConnection();
		PreparedStatement pstm = conn.prepareStatement("select * from accounts where account_no=?");
		pstm.setInt(1,selaccno);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		double newbal=rs.getDouble(4)+amt;
		PreparedStatement pstm2 = conn.prepareStatement("UPDATE accounts SET current_bal=? WHERE account_no=?");
		pstm2.setInt(1,selaccno );
		pstm2.setDouble(2, newbal);
		int rowsAffected = pstm2.executeUpdate();
		DBConnection.closeConnection();
		return rowsAffected;
	}


	public int withdraw(int selaccno, double amt)  throws ClassNotFoundException, SQLException
	{
		Connection conn = DBConnection.openConnection();
		PreparedStatement pstm = conn.prepareStatement("select * from accounts where account_no=?");
		pstm.setInt(1,selaccno);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		double newbal=rs.getDouble(4)-amt;
		PreparedStatement pstm2 = conn.prepareStatement("UPDATE accounts SET current_bal=? WHERE account_no=?");
		pstm2.setInt(1,selaccno );
		pstm2.setDouble(2, newbal);
		int rowsAffected = pstm2.executeUpdate();
		DBConnection.closeConnection();
		return rowsAffected;
	}
}