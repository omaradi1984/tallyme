package com.test.servlets;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.ApplicationDaoUser;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(
		name = "LoginServlet", 
		description = "A Servlet to handle login requests", 
		urlPatterns = { 
				"/LoginServlet", 
				"/loginServlet", 
				"/login", 
				"/Login"
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/html/login.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//call DAO for validation logic
				ApplicationDaoUser dao= new ApplicationDaoUser();
				boolean isValidUser = dao.validateUser(username, password);
				
				//check if user is invalid and set up an error message
				if(isValidUser){
					//set up the HTTP session
					HttpSession session = request.getSession();
					
					//set the username as an attribute
					session.setAttribute("username", username);
					//forward to home jsp
					request.getRequestDispatcher("/html/home.jsp").forward(request, response);
				}
				else{
					String errorMessage="Invalid Credentials, please login again! or signup to create an account";
					request.setAttribute("error", errorMessage);
					request.getRequestDispatcher("/html/login.jsp").forward(request, response);
					
				}
		
	}
}
