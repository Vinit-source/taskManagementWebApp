package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;
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
 * Servlet implementation class DeleteTaskServlet
 */
@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTaskServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TaskService taskService = new TaskService();
		List<Task> tasks = null;

		try {
			taskService.deleteTask(id);
			tasks = taskService.getAllTasks();
			HttpSession session = request.getSession(false);
			session.setAttribute("taskList", tasks);
			response.sendRedirect("tasks_list.jsp");
		} catch (ServiceException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("tasks_list.jsp?errorMessage=" + e.getMessage());
			dispatcher.forward(request, response);
			e.printStackTrace();
		}

	}

}
