package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.model.User;
import com.fssa.learnJava.project.taskapp.services.TaskService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * Servlet implementation class GetAllTasks
 */
@WebServlet("/GetAllTasksServlet")
public class GetAllTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		List<Task> tasks = new ArrayList<>();

		HttpSession session = request.getSession(false);
		String loggedInEmail = (String) session.getAttribute("loggedInEmail");

		if (loggedInEmail != null) {
			TaskService taskService = new TaskService();
			try {
				tasks = taskService.getAllTasks();

//				
//				tasks.add(new Task(1, "Get groceries", "PENDING"));
//				tasks.add(new Task(2, "Go for a walk", "PENDING"));
//				tasks.add(new Task(3, "Wash clothes", "PENDING"));
				request.setAttribute("taskList", tasks);
//				HttpSession session = request.getSession(false);
//				session.setAttribute("taskList", tasks);
//				System.out.println(session.getAttribute("loggedInEmail"));
//				request.setAttribute("demoAttribute", "Hi!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("tasks_list.jsp");
				dispatcher.forward(request, response);
			} catch (ServiceException | RuntimeException e) {
				e.printStackTrace();
				response.sendRedirect("login.jsp?errorMessage=" + e.getMessage());
			}

		} else {
			response.sendRedirect("login.jsp?errorMessage=Please login before viewing your tasks.");
		}

	}

}