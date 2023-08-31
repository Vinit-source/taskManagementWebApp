<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display all Tasks</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<table class=" table table-bordered">
		<thead>
			<tr>
				<th>Sr. No.</th>
				<th>Task</th>
				<th colspan="2">Action</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="task" items="${taskList}" varStatus="loop">

				<tr>
					<td><c:out value="${loop.index + 1}" /></td>
					<td><c:out value="${task.task}" /></td>
					<td><a href="updateTask?id=${task.id}">Edit Task Status</a></td>
					<td><a href="deleteTask?id=${task.id}">Delete Task Status</a></td>
					<!--<td><form name="submitForm" method="POST"
							action="/EditTaskServlet">
							<input type="hidden" name="taskId" value="${task.id}">
							<input type="submit" name="" value="Edit task">
						</form></td>-->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addNewTask"><button>Add New Task</button></a>
</body>
</html>