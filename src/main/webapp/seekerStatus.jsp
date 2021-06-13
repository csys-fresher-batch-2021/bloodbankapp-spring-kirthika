<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Donor</title>
<%
String loggedInUsername = (String) session.getAttribute("LOGIN_USER");
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>Seeker Status</h3>
		</div>
		<form action="SeekerStatus">

			<div class="d-flex justify-content-center">
				<label for="donorName"></label> <input type="text" name="seekerName"
					placeholder="Enter Seeker name" required autofocus />
			</div>

			<br />



			<div class="d-flex justify-content-center">
				<label for="mobileNumber"></label> <input type="number"
					name="mobileNumber" placeholder="Enter mobile number" required
					autofocus />
			</div>
			<br />
			<%
			String message = request.getParameter("errorMessage");
			if (message == null) {
				out.print("");
			} else {
				out.print("<font color='red'><center>" + message + "</font>");
			}
			%>
			<br /> <br />
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Status</button>
			</div>
		</form>

	</main>
</body>
</html>