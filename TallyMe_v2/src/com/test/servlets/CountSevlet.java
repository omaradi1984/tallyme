package com.test.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.beans.Count;
import com.test.beans.CountLog;
import com.test.beans.User;
import com.test.dao.ApplicationDao;

/**
 * Servlet implementation class CountSevlet
 */
@WebServlet("/count")

public class CountSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static CountLog log = new CountLog();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			ApplicationDao dao = new ApplicationDao();
		
		String username = request.getSession().getAttribute("username").toString();
		String password = request.getSession().getAttribute("password").toString();
		
		User user = dao.readUser(username, password);
				
		String buttonValue = request.getParameter("button");
		String add = "addCount";
		String delete = "deleteCount";
		int totalCount = dao.readCount(log);
		
		System.out.println("Username in profile servlet  :"+ user.getUsername());
	/*	System.out.println("User ID in profile servlet  :"+ user.getInternalId());
		System.out.println("First name in profile servlet  :"+ user.getFirstName());
		System.out.println("Last name in profile servlet  :"+ user.getLastName());
		System.out.println("Email Address in profile servlet  :"+ user.getEmailAddress());
		System.out.println("Password in profile servlet  :"+ user.getPassword());
		System.out.println();
		System.out.println("Name of button:" + buttonValue);
		System.out.println();
		System.out.println("Log ID:" + log.getInternalId());
		System.out.println();
		System.out.println("Log timestamp:" + log.getTimeStamp());
		System.out.println();
		System.out.println("Log location:" + log.getLocation());
		System.out.println();
		System.out.println("Total count: " + totalCount);
		System.out.println();*/
		
		if(!dao.validateCountLog(log, user)) {
				if(buttonValue != null && buttonValue.equalsIgnoreCase(add)) {
					Count count = new Count();
					log.add(count);
					dao.createCountLog(log, user);
					dao.createCount(count, log);
					System.out.println("count 1 up");
					totalCount = dao.readCount(log);
					System.out.println("Total count: " + totalCount);
				}else if(buttonValue != null && buttonValue.equalsIgnoreCase(delete)) {
					dao.deleteCount(log);
					System.out.println("1 count deleted");
					totalCount = dao.readCount(log);
					System.out.println("Total count: " + totalCount);
				}	
		}else {
			if(buttonValue != null && buttonValue.equalsIgnoreCase(add)) {
				Count count = new Count();
				log.add(count);
				dao.createCount(count, log);
				System.out.println("count 1 up");
				totalCount = dao.readCount(log);
				System.out.println("Total count: " + totalCount);
			}else if(buttonValue != null && buttonValue.equalsIgnoreCase(delete)) {
				dao.deleteCount(log);
				System.out.println("1 count deleted");
				totalCount = dao.readCount(log);
				System.out.println("Total count: " + totalCount);
			}	
		}
		request.setAttribute("totalCount", totalCount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/html/count.jsp");
		dispatcher.include(request, response);
		}catch (IOException exception) {
			exception.getStackTrace();
		}catch (ServletException exception) {
			exception.getStackTrace();
		}
	}
}