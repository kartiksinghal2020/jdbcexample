package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.Customers;

public interface ICustomerDao {
	//This is for Login
	Customers authenticateUser(String email, String passwd) throws SQLException;
	
	int Registration(double deposit_amt, String email, String name, String password, Date reg_date, String role)
			throws SQLException;
	
	int changePassword(String email, String oldPasswd, String newPasswd) throws SQLException;
	
	int deleteUser(int id) throws SQLException;
	
	//This is for all users details
	List<Customers> allUsersDetails() throws SQLException;

	

}
