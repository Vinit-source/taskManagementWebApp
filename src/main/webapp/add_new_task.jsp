
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Task</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="error_message.jsp"></jsp:include>
	<h1>Add New Task</h1>
	
	<form action="addNewTask" method="post">

		<label>Task: </label> <input type="taskName" name="taskName"
			placeholder="Enter task details... "> <br /> <label for="taskStatus">Task
			Status: </label> <select id="taskStatus" name="taskStatus">
			<option value="PENDING">Pending</option>
			<option value="COMPLETED">Completed</option>
			<!-- The taskStatus dropdown allows selecting the task status -->
		</select> <br />
		<button type="submit">Submit</button>
	</form>
</body>
</html>
