package mypack;

public class CustomerAccount {
	
	private String uname;
	private String name;
	private int pinCode;
	private int account_no;
	private double current_bal;
	private String account_type;
	public CustomerAccount(String uname, String name, int pinCode,
			int account_no, double current_bal, String account_type) {
		super();
		this.uname = uname;
		this.name = name;
		this.pinCode = pinCode;
		this.account_no = account_no;
		this.current_bal = current_bal;
		this.account_type = account_type;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public double getCurrent_bal() {
		return current_bal;
	}
	public void setCurrent_bal(double current_bal) {
		this.current_bal = current_bal;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	@Override
	public String toString() {
		return "CustomerAccount [uname=" + uname + ", name=" + name
				+ ", pinCode=" + pinCode + ", account_no=" + account_no
				+ ", current_bal=" + current_bal + ", account_type="
				+ account_type + "]";
	}
	
}
