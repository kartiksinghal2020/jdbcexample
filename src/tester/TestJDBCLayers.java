package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.CustomerDaoImpl;

public class TestJDBCLayers {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			CustomerDaoImpl cust = new CustomerDaoImpl();
			boolean exit = false;
			while(!exit) {
				try {
					System.out.println("Menu : \n 1.User Login \n 2.New User\n 3.Change Password \n 4.UnSuscribe \n 5.Show All Users \n 6.Quit");
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter email n password:");
						String email = sc.next();
						String passwd = sc.next();
						System.out.println(cust.authenticateUser(email, passwd));
						break;
					case 2:
						System.out.println("Plz enter new User details:");
						int v1=cust.Registration(sc.nextDouble(),sc.next(),sc.next(),sc.next(),Date.valueOf(sc.next()),sc.next());
						if(v1 == 0)
							System.out.println("Unsuccesful");
						else
							System.out.println("Registered Successfully...");
						break;
					case 3:
						System.out.println("Plz enter Email and passwd whose passwd u want to change:");
						int v2 = cust.changePassword(sc.next(), sc.next(), sc.next());
						if(v2 ==1)
							System.out.println("Updated Successfully");
						else
							System.out.println("Not updated");
						break;
					case 4:
						System.out.println("Delete user Details: ");
						int v3 = cust.deleteUser(sc.nextInt());
						if(v3 == 1) {
							System.out.println("Deleted Successfully!!!!!");
						}
						else
							System.out.println("Not deleted.");
						break;
					case 5:
						System.out.println("All Present Customers in database are: ");
						cust.allUsersDetails().forEach(System.out::println);;
						break;
					case 6:
						cust.cleanUp();
						exit = true;
						break;
					default:
						System.out.println("Incorrect input");
					}
				}catch(Exception e) {
					System.out.println("Error : "+e);
					System.out.println("Plz retry...");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
