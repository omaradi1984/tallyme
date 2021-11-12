package com.test.servlets;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.*;
import com.test.inmemory.ApplicationInMemory;
import com.test.services.ApplicationService;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(
		name = "UserServlet", 
		description = "A Servlet to handle signup requests", 
		urlPatterns = { 
				"/UserServlet", 
				"/userServlet", 
				"/user", 
				"/User"
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ApplicationService users = openUsers();
		
		String internalId = request.getParameter("internalId");
		String firstName = "";
		//int id;
		String lastName = "";
		String username = "";
		String password = "";
		String emailAddress = "";
		
		if (internalId == null || "".equals(internalId)) {
            // Initialize id and continue with the rendering.
			internalId = "";
        } else {
            // Read the record from memory.
            User user = users.readUser(internalId);
            if (user == null) {
                // User not found, initialize id and continue with the rendering.
                internalId = "";
            } else {
                // User found, initialize title and content.
            	firstName = user.getFirstName();
        		//int id;
        		lastName = user.getLastName();
        		username = user.getUsername();
        		password = user.getPassword();
        		emailAddress = user.getEmailAddress();
            }
        }
		
		// Render response.
        String htmlResponse = printOutHead(request.getContextPath());
        htmlResponse += printOutBodyForm(internalId, firstName, lastName, username, password, emailAddress);
        // Read all logs, assign to local variable and sent to printOutBodyList
        htmlResponse += printOutBodyList(users.readUsers());
        htmlResponse += printOutFoot();
        PrintWriter writer = response.getWriter();
        writer.write(htmlResponse);
        closeUsers(users);
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String printOutHead(String root) {
        String out = "<!DOCTYPE html>\n" + "	<html lang=\"en\">\n" + "	    <head>\n"
                + "	        <title>Welcome to tallyme.ca</title>\n" + "         <body id=\"page-top\">\n";

        return out;
    }
	
	private String printOutBodyForm(String id, String firstname, String lastname, String username, String password, String email) {
        String out = "<!DOCTYPE html>\r\n"
        		+ "<html lang=\"en\">\r\n"
        		+ "<head>\r\n"
        		+ "<meta charset=\"UTF-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
        		+ "    <title>Welcome to TallyMe.ca</title>\r\n"
        		+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/signup-style.css\">\r\n"
        		+ "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700\" rel=\"stylesheet\">\r\n"
        		+ "</head>\r\n"
        		+ "<body class=\"signup\">\r\n"
        		+ "<form name=\"signupForm\" method=\"POST\" action=\"user\">\r\n"
        		+ "<fieldset>\r\n"
        		+ "    <legend>\r\n"
        		+ "        <h1>Enter your account details</h1>\r\n"
        		+ "    </legend>\r\n"
        		+ "    <table>\r\n"
        		+ "        <tr>\r\n"
        		+ "        		 <td><input type=\"hidden\" id=\"firstName\" name=\"internalId\" class=\"large\" value=\""+ id + "\r\n"
        		+ "        		  placeholder=\"Enter your first name\" /></td>\r\n"
        		+ "        	     </tr>\r\n"
        		+ "			<tr>\r\n"
        		+ "          <td class=\"label\"><label for=\"firstName\">First name: <span class=\"required\"></span></label></td>\r\n"
        		+ "          <td><input type=\"text\" id=\"firstName\" name=\"firstName\" class=\"large\" value=\"\""+ firstname + "\r\n"
        		+ "              placeholder=\"Enter your first name\" /></td>\r\n"
        		+ "        </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td class=\"label\"><label for=\"lastName\">Last name: <span class=\"required\"></span></label></td>\r\n"
        		+ "          <td><input type=\"text\" id=\"lastName\" name=\"lastName\" class=\"large\" value=\"\"\""+ lastname + "\r\n"
        		+ "              placeholder=\"Enter your last name\" /></td>\r\n"
        		+ "        </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td class=\"label\"><label for=\"emailAddress\">Email address: <span class=\"required\"></span></label></td>\r\n"
        		+ "          <td><input type=\"text\" id=\"emailAddress\" name=\"emailAddress\" class=\"large\" value=\"\"\""+ email + "\r\n"
        		+ "              placeholder=\"Enter your email address\" /></td>\r\n"
        		+ "        </tr>\r\n"
        		+ "        <tr>\r\n"
        		+ "          <td class=\"label\"><label for=\"username\">Username: <span class=\"required\"></span></label></td>\r\n"
        		+ "          <td><input type=\"text\" id=\"username\" name=\"username\" class=\"large\" value=\"\"\""+ username + "\r\n"
        		+ "              placeholder=\"Enter your username\" /></td>\r\n"
        		+ "        </tr>\r\n"
        		+ "                <tr>\r\n"
        		+ "          <td class=\"label\"><label for=\"password\">Password: <span class=\"required\"></span></label></td>\r\n"
        		+ "          <td><input type=\"text\" id=\"password\" name=\"password\" class=\"large\" value=\"\"\""+ password + "\r\n"
        		+ "              placeholder=\"Enter your password\" /></td>\r\n"
        		+ "        </tr>\r\n"
        		+ "    </table>\r\n"
        		+ "\r\n"
        		+ "<input type=\"button\" value=\"Cancel\" onclick=\"window.location='users'\">\n"
        		+ "<input type=\"reset\" value=\"Clear\"/>\r\n"
        		+ "<input type=\"submit\" value=\"Create account\"/>\r\n"
        		+ "</fieldset>\r\n"
        		+ "    </form>\r\n"
        		+ "</body>\r\n"
        		+ "</html>";

        return out;
    }

	private String printOutBodyList(Map<UUID, User> users) {
        // Body list top.
        String out = "\n" + "        <!-- Content Section-->\n" + "            <!-- Users-->\n"
                + "            <div class=\"row\">\n";
        // This is the actual List.
        out += "                  <table class=\"table\">\n" + "                    <thead>\n"
                + "                      <tr>\n" + "                        <th scope=\"col\" class=\"col-2\">#</th>\n"
                + "                        <th scope=\"col\" class=\"col-2\">Title</th>\n"
                + "                        <th scope=\"col\">Content</th>\n"
                + "                        <th scope=\"col\" class=\"col-2\">Actions</th>\n"
                + "                      </tr>\n" + "                    </thead>\n" + "                    <tbody>\n";

        for (Map.Entry<UUID, User> user : users.entrySet()) {
            out += printOutBodyUser(user.getValue().getInternalId().toString(), user.getValue().getFirstName(),
            		user.getValue().getLastName(), user.getValue().getEmailAddress(), user.getValue().getUsername(), user.getValue().getPassword());
        }
        out += "                    </tbody>\n" + "                  </table>\n";
        // Body list bottom.
        out += "            </div>\n";

        return out;
    }
	
	private String printOutBodyUser(String id, String firstname, String lastname, String username, String password, String email) {
        String out = "                      <tr>\n" + "                        <th scope=\"row\">" + id.substring(0, 8)
                + "</th>\n" + "                        <td>" + firstname + "</td>\n" + "                        <td>"
                + lastname + "</td>\n" + "                        <td>" + "<a href=\"users?id=" + id + "\">Edit</a>\n"
                + "<a href=\"users?id=" + id + "&action=delete\">Delete</a>\n" + "                      </td>\n"
                + "                      </tr>\n";

        return out;
    }

    private String printOutFoot() {
        String out = "    </body>\n" + "</html>\n";

        return out;
    }
	
	private ApplicationService openUsers() {
        ApplicationService users;

        ServletContext sc = getServletContext();
        users = (ApplicationService) sc.getAttribute("users"); // getting attribute on context scope

        if (users == null) {
        	users = new ApplicationInMemory();
//            logs = new ApplicationDao();
        }
        return users;
    }

    private void closeUsers(ApplicationService users) {
        ServletContext sc = getServletContext();
        sc.setAttribute("users", users); // setting attribute on context scope
    }
}
