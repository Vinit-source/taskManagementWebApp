package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;

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
 * Servlet implementation class AddNewTaskServlet
 */
@WebServlet("/addNewTask")
public class AddNewTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add_new_task.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskName = request.getParameter("taskName");
		String taskStatus = request.getParameter("taskStatus");
		Task task = new Task(taskName, taskStatus);
		
		TaskService taskService = new TaskService();
		try {
			taskService.addTask(task);
		} catch (ServiceException e) {
			e.printStackTrace();
			response.sendRedirect("add_new_task.jsp?errorMessage=" + e.getMessage());
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("task_list.jsp");
		dispatcher.forward(request, response);
	}

}
