package pojos;

import java.sql.Date;

// id | deposit_amt | email          | name    | password | reg_date   | role
public class Customers {
	private int id;
	private double deposit_amt;
	private String email;
	private String name;
	private String passwd;
	private Date reg_date;
	private String role;
	
	public Customers() {
		
	}

	public Customers(int id, double deposit_amt, String email, String name, String passwd, Date reg_date, String role) {
		super();
		this.id = id;
		this.deposit_amt = deposit_amt;
		this.email = email;
		this.name = name;
		this.passwd = passwd;
		this.reg_date = reg_date;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", deposit_amt=" + deposit_amt + ", email=" + email + ", name=" + name
				+ ", passwd=" + passwd + ", reg_date=" + reg_date +  ", role=" + role +"]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDeposit_amt() {
		return deposit_amt;
	}

	public void setDeposit_amt(double deposit_amt) {
		this.deposit_amt = deposit_amt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	

}
