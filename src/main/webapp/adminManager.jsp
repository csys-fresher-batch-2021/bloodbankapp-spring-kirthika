<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Blood Bank</title>
<%
String loggedInUsername = (String) session.getAttribute("LOGIN_USER");
%>


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<%
			if (!loggedInUsername.equals("admin")) {
			%>
			<h3>
				Welcome
				<%=" " + loggedInUsername%>
				to the Blood Bank
			</h3>
			<%
			} else {
			%>
			<h3>
				Welcome
				<%=" " + loggedInUsername%>
				to the Blood Bank
			</h3>
			<%
			}
			%>
		</div>
		<br />



	</main>
</body>
</html>