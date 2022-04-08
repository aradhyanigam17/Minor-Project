package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.user.UserLogin;
import com.userdao.UserDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO userdao ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException{
    	userdao = new UserDAO() ;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html") ;
		
		String name = request.getParameter("user_email");
		String password = request.getParameter("user_password") ;
		
		PrintWriter out = response.getWriter();
		
//		out.println("<h2>"+name+" "+ password +"</h2>");
		
		UserLogin login = new UserLogin() ;
		
		login.setName(name) ;
		login.setPassword(password) ;
		
		boolean status = UserDAO.isloginValidate(login);
		
		if(status) {
			response.sendRedirect("loginSuccess.html");
			
			
		}
		else {
			response.sendRedirect("register.jsp") ;
		}
		
	}

}
