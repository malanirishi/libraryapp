import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypack.Account;
import mypack.Customer;
import mypack.CustomerAccount;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		boolean aornot = false;
		boolean cornot = false;
		String uname = null;
		Customer addcus = null;
		Account account = null;
		AdminDao adao = new AdminDao();
		CustomerDAO cdao = new CustomerDAO();
		if (action.equals("login")) {
			uname = request.getParameter("txtUsername");
			String pass = request.getParameter("txtPassword");

			aornot = adao.validateAdmin(uname, pass);
			try {
				cornot = cdao.validateCustomer(uname, pass);
			} catch (ClassNotFoundException e) {
				System.out.println("Error!!!Class does not exist..");
			} catch (SQLException e) {
				System.out.println("Error!!!Query failed to be executed..");
			}
		}
		if (aornot == true) {
			// HttpSession session = request.getSession(true);
			request.getSession().setAttribute("name", uname);
			// session.setAttribute("name",uname);//////////////////////////////////////
			response.sendRedirect("AdminMenu.jsp");
		}
		if (cornot == true) {
			// HttpSession session = request.getSession(true);
			request.getSession().setAttribute("uname", uname);
			// session.setAttribute("name",uname);//////////////////////////////////////
			response.sendRedirect("CustomerMenu.jsp");
		}

		// ADMIN FUNCTIONS
		else if (action.equals("add")) {
			response.sendRedirect("AddNewCustomer.jsp");
		} else if (action.equals("addCustomer")) {
			System.out.println("Add.......");

			uname = request.getParameter("txtUsername");
			request.getSession().setAttribute("addcusname", uname);
			String name = request.getParameter("txtCustomerName");
			String password = request.getParameter("txtPassword");
			String address = request.getParameter("txtAddress");
			String city = request.getParameter("txtCity");
			String state = request.getParameter("txtState");
			int pinCode = Integer.parseInt(request.getParameter("numPin"));
			int phoneNumber = Integer.parseInt(request
					.getParameter("numPhoneNumber"));
			String email = request.getParameter("txtEmail");
			String isAccount = request.getParameter("isAccount");
			request.getSession().setAttribute("isAccount", isAccount);
			addcus = new Customer(uname, name, password, address, city, state,
					pinCode, phoneNumber, email);
			try {
				int rowsAffected = adao.insertCustomer(addcus);
				if (rowsAffected > 0) {
					// response.sendRedirect("Success.jsp");
					System.out.println("Customer Inserted");
					response.sendRedirect("Success.jsp");
				}

			} catch (ClassNotFoundException e) {
				System.out.println("Error!!!Class does not exist..");
			} catch (SQLException e) {
				System.out.println("Error!!!Query failed to execute..");
			}
			request.setAttribute("currentUname", uname);
			if (null!=isAccount){
				if(isAccount.equals("yes"))
					response.sendRedirect("AddNewAccount.jsp");
				
			}
		}
		/*
		 * else if(action.equals("addacc")) { //System.out.println(isAccount);
		 * response.sendRedirect("AddNewAccount.jsp"); }
		 */
		else if (action.equals("addAccount")) {
			double min_bal = 0.0;
			int account_no = Integer.parseInt(request
					.getParameter("txtAccount_No"));
			String opening_date = request.getParameter("txtOpening_Date");
			double current_bal = Double.parseDouble(request
					.getParameter("txtCurrent_Bal"));
			double rate_of_intrest = Double.parseDouble(request
					.getParameter("txtRate_Of_Intrest"));
			String account_type = request.getParameter("acctype");
			uname = request.getParameter("txtUname");
			double odlimit = 0.0;
			if (account_type.equals("Current")) {
				odlimit = Double
						.parseDouble(request.getParameter("txtOdlimit"));
			} else {
				min_bal = Double
						.parseDouble(request.getParameter("txtMin_Bal"));
			}

			account = new Account(account_no, opening_date, min_bal,
					current_bal, rate_of_intrest, account_type, uname, odlimit);
			try {

				int rowsAffected = adao.insertAccount(account);
				if (rowsAffected > 0) {
					// response.sendRedirect("Success.jsp");
					System.out.println("Account Inserted");
					response.sendRedirect("AdminMenu.jsp");
				}

			} catch (ClassNotFoundException e) {
				System.out.println("Error!!!Class does not exist..");
			} catch (SQLException e) {
				System.out.println("Error!!!Query failed to execute..");
			}
		}

		else if (action.equals("view")) {
			System.out.println("View All Employees.....");
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			try {
				customerList = adao.viewCustomers();
				request.setAttribute("customerList", customerList);
				RequestDispatcher rd = request
						.getRequestDispatcher("ViewCustomers.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action.equals("search")) {
			response.sendRedirect("SearchCustomer.jsp");
		} else if (action.equals("searchCustomer")) {

			System.out.println("Search Employees.....");
			String username = request.getParameter("txtUsername");
			Customer customer;
			try {
				customer = adao.searchCustomers(username);
				request.setAttribute("customer", customer);
				RequestDispatcher rd = request
						.getRequestDispatcher("DisplayCustomer.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action.equals("viewAllCusAcccounts")) {
			try {
				System.out.println("Inside Block");
				ArrayList<CustomerAccount> cusAccountList = adao
						.viewAllCustomersAccounts();
				for (CustomerAccount customerAccount : cusAccountList) {
					System.out.println(customerAccount);
				}
				request.setAttribute("cusAccountList", cusAccountList);
				RequestDispatcher rd = request
						.getRequestDispatcher("ViewAllCustomersAccounts.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// CUSTOMER FUNCTIONS

		/*
		 * else if(action.equals("VPD")) { try { CustomerAccount customerAccount
		 * = cdao.viewPersonalDetails(uname);
		 * 
		 * System.out.println(customerAccount); } catch (ClassNotFoundException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
		else if (action.equals("VAD")) {
			ArrayList<Account> accountlist = new ArrayList<Account>();
			try {
				String customerSession = request.getSession()
						.getAttribute("uname").toString();
				System.out.println(customerSession);
				accountlist = cdao.viewAccountDetails(customerSession);
				request.setAttribute("accList", accountlist);
				RequestDispatcher rd = request
						.getRequestDispatcher("ViewAccounts.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action.equals("getAcc")) {
			int selaccno = Integer.parseInt(request.getParameter("accno"));
			request.getSession().setAttribute("selaccno", selaccno);
			try {
				Account selacc = cdao.getAccount(selaccno);
				System.out.println(selacc);
				request.setAttribute("selacc", selacc);
				RequestDispatcher rd = request
						.getRequestDispatcher("DisplayAccount.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// ACCOUNT FUNCTIONS
		else if (action.equals("dep")) {
			int selaccno = Integer.parseInt(request.getParameter("accno"));
			request.getSession().getAttribute("selaccno");
			try {
				Account selacc = cdao.getAccount(selaccno);
				System.out.println(selacc);
				request.setAttribute("selacc", selacc);
				RequestDispatcher rd = request
						.getRequestDispatcher("Deposit.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("deposit")) {
			System.out.println("Search Employees.....");
			int depinacc = Integer.parseInt(request.getParameter("txtaccno"));
			double depamt = Double.parseDouble(request
					.getParameter("txtdepamt"));
			AccountDao accdao = new AccountDao();
			try {
				int rowsaffected = accdao.deposit(depinacc, depamt);
				if (rowsaffected > 0) {
					// response.sendRedirect("Success.jsp");
					System.out.println("Amount Deposited");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action.equals("with")) {
			int selaccno = Integer.parseInt(request.getParameter("accno"));
			request.getSession().getAttribute("selaccno");
			try {
				Account selacc = cdao.getAccount(selaccno);
				System.out.println(selacc);
				request.setAttribute("selacc", selacc);
				RequestDispatcher rd = request
						.getRequestDispatcher("Withdraw.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("withdraw")) {
			System.out.println("Search Employees.....");
			int withinacc = Integer.parseInt(request.getParameter("txtaccno"));
			double withamt = Double.parseDouble(request
					.getParameter("txtwithamt"));
			AccountDao accdao = new AccountDao();
			try {
				int rowsaffected = accdao.withdraw(withinacc, withamt);
				if (rowsaffected > 0) {
					// response.sendRedirect("Success.jsp");
					System.out.println("Amount Withdrawn");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
