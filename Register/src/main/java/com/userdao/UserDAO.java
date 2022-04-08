package com.userdao;

import java.sql.* ;

import com.mysql.cj.protocol.Resultset;
import com.user.User;
import com.user.UserLogin;
public class UserDAO {

	public static Connection getConnection() {
		Connection con = null ;
		
		System.out.println("getConnection");
//		?enabledTLSProtocols=TLSv1.2 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver");

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripto", "root", "root");
			System.out.println("db  connc");
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con ;
		
	}
	
	public static int saveData(User user) {
		
		int status = 0 ; 
		
		System.out.println("savedata");
		Connection connection = UserDAO.getConnection(); //to get connection 
		
		System.out.println("con : " + connection);

		try {
			PreparedStatement st = connection.prepareStatement("insert into user(name , email,password,number,address,city,pincode,country) values(?,?,?,?,?,?,?,?)");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getNumber());

			st.setString(5, user.getAddress());
			st.setString(6, user.getCity());
			st.setString(7, user.getPincode());
			st.setString(8, user.getCountry());
			
			status = st.executeUpdate() ; // this method is used to insert ,delete,update query 
			
			System.out.println("status : " + status);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status ;
	}
	
	//login method
	
	public static boolean isloginValidate(UserLogin userLogin) {
		Connection con = UserDAO.getConnection() ;
		boolean status = false ;
		try {
			PreparedStatement st = con.prepareStatement("select * from user where email = ? and password = ?");
			st.setString(1,userLogin.getName());
			st.setString(2,userLogin.getPassword());
			
			ResultSet rs = st.executeQuery() ; //Resultset points to first row
			
//			System.out.println("Resultset : "+ rs );
//			System.out.println("Next Resultset : " + rs.next());
			
			status = rs.next() ;
//			rs.getNextResultset();
			System.out.println("Status : " + status);

			
 
		}
		
		
		catch(Exception e) {
			System.out.println("Error");
		}
		
		return status;
	}
	
	
}
