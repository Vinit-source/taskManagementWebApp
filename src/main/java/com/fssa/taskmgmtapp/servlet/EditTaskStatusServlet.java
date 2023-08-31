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
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit_task.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Task editedTask =(Task)session.getAttribute("editedTask");
		TaskService taskService = new TaskService();
		try {
			taskService.updateTask(editedTask);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Task> tasks = (List<Task>) session.getAttribute("taskList");
		int id = Integer.parseInt((String)session.getAttribute("id"));
		tasks.set(id-1, editedTask);
		session.setAttribute("taskList", tasks);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("tasks_list.jsp");
		dispatcher.forward(request, response);
	}


}
