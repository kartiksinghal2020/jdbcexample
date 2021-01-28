package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Customers;
import static utils.DBUtils.fetchDBConnection;
public class CustomerDaoImpl implements ICustomerDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4,pst5;
	
	public  CustomerDaoImpl() throws ClassNotFoundException,SQLException{
		String sql = "select id , deposit_amt ,email, name , password , reg_date,role from my_customers where email = ? and password =?";
		String sqlForInsert ="Insert into my_customers values(default,?,?,?,?,?,?)";
		String sqlForUpdate ="update my_customers set password=? where email=? and password =?";
		String sqlForDelete ="delete from my_customers where id =?";
		String sqlAllCust = "select * from my_customers";
		cn = fetchDBConnection();
		pst1 = cn.prepareStatement(sql);
		pst2 = cn.prepareStatement(sqlForInsert);
		pst3 = cn.prepareStatement(sqlForUpdate);
		pst4 = cn.prepareStatement(sqlForDelete);
		pst5 =cn.prepareStatement(sqlAllCust);
		System.out.println("end dao created");
	}

	@Override
	public Customers authenticateUser(String email, String passwd) throws SQLException {
		
		pst1.setString(1, email);
		pst1.setString(2, passwd);
		try(ResultSet rst = pst1.executeQuery()){		
			Customers c;
			if(rst.next()) {
				 return  c =new Customers(rst.getInt(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDate(6),rst.getString(7));	
			}
		}
		return null;
	}
	

	@Override
	public int Registration(double deposit_amt,String email, String name,String password, Date reg_date, String role) throws SQLException {
		pst2.setDouble(1, deposit_amt);
		pst2.setString(2, email);
		pst2.setString(3, name);
		pst2.setString(4, password);
		pst2.setDate(5, reg_date);
		pst2.setString(6, role);
		int rst = pst2.executeUpdate();
		return rst;
	}
	
	@Override
	public int changePassword(String email, String oldPasswd, String newPasswd) throws SQLException {
		pst3.setString(1, newPasswd);
		pst3.setString(2, email);
		pst3.setString(3, oldPasswd);
		int rst = pst3.executeUpdate();
		return rst;
	}

	@Override
	public int deleteUser(int id) throws SQLException {
		pst4.setInt(1, id);
		int rst = pst4.executeUpdate();
		return rst;
	}

	@Override
	public List<Customers> allUsersDetails() throws SQLException {
		List<Customers> listOfCust = new ArrayList<Customers>();
		try(ResultSet rst = pst5.executeQuery()){
			while(rst.next()) {
				listOfCust.add(new Customers(rst.getInt(1),rst.getDouble(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDate(6),rst.getString(7)));
			}
		}
		return listOfCust;
	}
	
	public void cleanUp() throws SQLException{
		if(pst1 != null) {
			pst1.close();
		}
		if(cn != null) {
			cn.close();
		}
		System.out.println("Customer dao cleaned up");
	}



}
