package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.fssa.learnJava.project.taskapp.model.Task;

/**
 * Servlet implementation class GetAllTasks
 */
@WebServlet("/GetAllJSONTasksServlet")
public class GetAllJSONTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Task> tasks = new ArrayList<Task> ();
		
		tasks.add(new Task("Get groceries", "PENDING"));
		tasks.add(new Task("Go for a walk", "PENDING"));
		tasks.add(new Task("Wash clothes", "PENDING"));
		JSONArray tasksJSONArray = new JSONArray(tasks);
		PrintWriter out = response.getWriter();
		out.println(tasksJSONArray.toString());
		out.flush();
	}

}