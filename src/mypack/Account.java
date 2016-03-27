package mypack;

public class Account {

	private int account_no;
	private String opening_date;
	private double min_bal;
	private double current_bal;
	private double rate_of_intrest;
	private String account_type;
	private String uname;
	public double getODlimit;
	public Account(int account_no, String opening_date, double min_bal,
			double current_bal, double rate_of_intrest, String account_type,
			String uname, double getODlimit) {
		super();
		this.account_no = account_no;
		this.opening_date = opening_date;
		this.min_bal = min_bal;
		this.current_bal = current_bal;
		this.rate_of_intrest = rate_of_intrest;
		this.account_type = account_type;
		this.uname = uname;
		this.getODlimit = getODlimit;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public String getOpening_date() {
		return opening_date;
	}
	public void setOpening_date(String opening_date) {
		this.opening_date = opening_date;
	}
	public double getMin_bal() {
		return min_bal;
	}
	public void setMin_bal(double min_bal) {
		this.min_bal = min_bal;
	}
	public double getCurrent_bal() {
		return current_bal;
	}
	public void setCurrent_bal(double current_bal) {
		this.current_bal = current_bal;
	}
	public double getRate_of_intrest() {
		return rate_of_intrest;
	}
	public void setRate_of_intrest(double rate_of_intrest) {
		this.rate_of_intrest = rate_of_intrest;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getGetODlimit() {
		return getODlimit;
	}
	public void setGetODlimit(double getODlimit) {
		this.getODlimit = getODlimit;
	}
	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", opening_date="
				+ opening_date + ", min_bal=" + min_bal + ", current_bal="
				+ current_bal + ", rate_of_intrest=" + rate_of_intrest
				+ ", account_type=" + account_type + ", uname=" + uname
				+ ", getODlimit=" + getODlimit + "]";
	}
	
}
