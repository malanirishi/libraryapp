package mypack;
public class Customer {
	private String uname;
	private String name;
	private String password;
	private String address;
	private String city;
	private String state;
	private int pinCode;
	private int phoneNumber;
	private String email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(String uname, String name, String password, String address,
			String city, String state, int pinCode, int phoneNumber,
			String email) {
		super();
		this.uname = uname;
		this.name = name;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [uname=" + uname + ", name=" + name + ", password="
				+ password + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pinCode=" + pinCode
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	
}
