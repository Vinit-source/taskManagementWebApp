<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Delete Task</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Delete Task</h1>
	

	<!-- TODO: add redirect after clicking Update Task status -->

	<!--<c:out value="${editableTask}"/>-->
	<!--<c:out value="${taskList}"/>-->

	<form action="deleteTask" method="post">
		<!-- You need to specify the action and method for form submission -->
		<label for="taskId">Task ID:</label> <input type="text" id="taskId"
			name="taskId" value="${toEditTask.id}" readonly>
		<!-- The taskId is read-only and should be populated with the task ID from the request -->

		<label for="taskName">Task Name:</label> <input type="text"
			id="taskName" name="taskName" value="${toEditTask.task}" readonly>
		<!-- The taskName input field can be used to edit the task name -->

		<label for="taskStatus">Task Status:</label> <select id="taskStatus"
			name="taskStatus">
			<option value="PENDING"
				${toEditTask.taskStatus == 'PENDING' ? 'selected' : ''}>Pending</option>
			<option value="COMPLETED"
				${toEditTask.taskStatus == 'COMPLETED' ? 'selected' : ''}>Completed</option>
			<!-- The taskStatus dropdown allows selecting the task status -->
		</select>

		<button type="submit">Update Task Status</button>
	</form>
</body>
</html>
