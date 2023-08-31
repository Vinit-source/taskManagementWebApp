
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Login Page</h1>
	<%
	String errorMessage = request.getParameter("errorMessage");
	if (errorMessage != null) {
		out.println("<p>" + errorMessage + "</p>");
	}
	%>
	<form action="login" method="post">

		<label>Email: </label> <input type="email" name="email"
			placeholder="Enter email"> <br /> <label>Password: </label>

		<input type="password" name="password" placeholder="Enter password">
		<br />
		<button type="submit">Submit</button>
	</form>
</body>
</html>
