package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.User;
import com.userdao.UserDAO;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 
		PrintWriter out = response.getWriter();
		out.print("<h1>Servlet<h1>");
		
		System.out.println("asdf");
		
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String number = request.getParameter("user_number");
		String address = request.getParameter("user_address");
		String city = request.getParameter("user_city");
		String pincode = request.getParameter("pincode") ;
		String country = request.getParameter("user_country") ;
		
		User user = new User() ;
		
		user.setName(name);
		user.setPassword(password);
		user.setNumber(number);
		user.setEmail(email) ;
		user.setAddress(address);
		user.setCity(city) ;
		user.setPincode(pincode);
		user.setCountry(country) ;
		
//		UserDAO.getConnection() ;
		
		
		int status  = UserDAO.saveData(user) ;
		
		if(status > 0 ) System.out.println("Insert") ;
		else System.out.println("not");
		
	}

}
