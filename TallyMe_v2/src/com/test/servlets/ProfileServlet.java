package com.test.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.User;
import com.test.dao.ApplicationDao;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//get the username from the session
		System.out.println("Username in profile servlet  :"+ request.getSession().getAttribute("username"));
		String username = (String)request.getSession().getAttribute("username");
		
		//call dao and get profile details
		ApplicationDao dao = new ApplicationDao();
		User user = dao.getProfileDetails(username);
		
		//store all information in request object
		request.setAttribute("user", user);
		
		//forward control to profile jsp
		request.getRequestDispatcher("/html/profile.jsp").forward(request, response);
		
	}

}
