package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.learnJava.project.taskapp.model.Task;
import com.fssa.learnJava.project.taskapp.services.TaskService;
import com.fssa.learnJava.project.taskapp.services.exception.ServiceException;

/**
 * Servlet implementation class EditTaskServlet
 */
@WebServlet("/updateTask")
public class EditTaskStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTaskStatusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		TaskService taskService = new TaskService();
		Task task = null;
		try {
			task = taskService.getTaskByID(id);
		} catch (ServiceException e) {
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
			e.printStackTrace();
		}

		request.setAttribute("toEditTask", task);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit_task.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("taskId"));
		String task = request.getParameter("taskName");
		System.out.println(" checkBox status: " + request.getParameter("isCompleted"));
		boolean isCompleted = "on".equals(request.getParameter("isCompleted").trim());
		System.out.println("isCompleted: " + isCompleted);
		String taskStatus = isCompleted ? "COMPLETED" : "PENDING";
		Task editedTask = new Task(id, task, taskStatus);
		List<Task> tasks = null;

		TaskService taskService = new TaskService();
		try {
			taskService.updateTask(editedTask);
			tasks = taskService.getAllTasks();
		} catch (ServiceException e) {
			// TODO Handle catch scenario
			e.printStackTrace();
		}

		request.setAttribute("taskList", tasks);

		RequestDispatcher dispatcher = request.getRequestDispatcher("tasks_list.jsp");
		dispatcher.forward(request, response);
	}

}
