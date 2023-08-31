package com.fssa.taskmgmtapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fssa.learnJava.project.taskapp.model.Task;

/**
 * Servlet implementation class GetAccountJSONServlet
 */
@WebServlet("/GetTaskJSONServlet")
public class GetTaskJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Task task = new Task("Convert task to JSON", "COMPLETED");
		
		JSONObject accountJson = new JSONObject(task);
		PrintWriter out = response.getWriter();
		out.println(accountJson.toString());
		out.flush();
	}

}