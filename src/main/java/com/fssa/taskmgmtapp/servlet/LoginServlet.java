package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.UserService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(email, password);

		PrintWriter out = response.getWriter();

//		UserService loginService = new UserService();
//		try {
//			if (loginService.login(user)) {
//				out.println("Login successful!");
//				HttpSession session = request.getSession();
//				session.setAttribute("loggedInEmail", email);
////				request.setAttribute("loggedInEmail", email); // Only the next page or servlet can access the request scope attribute values. 
//				RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
//				dispatcher.forward(request, response);
//			} else {
//				out.println("Login failed!");
//			}
//		} catch (ServiceException e) {
//			out.println(e.getMessage());
//		}

		if (email == null || "".equals(email)) {
			out.println("Invalid Email");
			response.sendRedirect("login.jsp?errorMessage=Invalid Email");
		}

		else if (password == null || "".equals(password) || password.length() < 6) {
			response.sendRedirect("login.jsp?errorMessage=Invalid Password");
		} else {
			out.println("Email and password is valid");
			HttpSession session = request.getSession();
			session.setAttribute("loggedInEmail", email);
//			request.setAttribute("loggedInEmail", email); // Only the next page or servlet can access the request scope attribute values. 
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}

	}

}