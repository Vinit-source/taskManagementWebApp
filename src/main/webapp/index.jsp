<html>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>Hello World!</h2>
	<!-- This is how you write comments in JSP -->

	<!--  Example of JSP Declaration -->
	<%!public String getMessage() {
		return "Success";
	}%>

	<!--  Example of Scriptlet -->
	<%
	String message = "Success";
	%>

	<!-- Expressions -->
	<%=message%>
	<%=getMessage()%>

	<div>
		<a href="GetAllTasksServlet"><button>List All Tasks</button></a>
	</div>
	<div>
		<a href="login.html"><button>Login</button></a>
	</div>

</body>
</html>
