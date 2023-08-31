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
import com.fssa.learnJava.project.taskapp.services.TaskService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * Servlet implementation class GetAllBookServlet
 */
@WebServlet("/ListTasksServlet")
public class ListTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loggedInEmail = (String) session.getAttribute("loggedInEmail");
		PrintWriter out = response.getWriter();
		if (loggedInEmail == null) {
			response.sendRedirect("login.html");
		} else {
//			TaskService taskService = new TaskService();

//			out.println("<h1>Printing all tasks</h1>");
//			try {
//
//				List<Task> tasksFromDB = taskService.getAllTasks();
//				out.println("<table><th><td>Task<td>Task status</th>");
//				for (Task task : tasksFromDB) {
//					out.println("<tr><td>" + task.getTask() + "<td>" + task.getTaskStatus() + "</tr>");
//				}
//				out.println("</table>");
//			} catch (ServiceException e) {
//				e.printStackTrace();
//				out.println(e.getMessage());
//			}
			
			List<Task> tasks = new ArrayList<Task> ();
			
			tasks.add(new Task("Get groceries", "PENDING"));
			tasks.add(new Task("Go for a walk", "PENDING"));
			tasks.add(new Task("Wash clothes", "PENDING"));
			request.setAttribute("taskList", tasks);
			RequestDispatcher dispatcher = request.getRequestDispatcher("users-list.jsp");
			dispatcher.forward(request, response);
			
			out.println("<p>Logged In user: " + loggedInEmail + "</p>");
			out.println("<a href='LogoutServlet'>logout</a>");
		}
	}

}