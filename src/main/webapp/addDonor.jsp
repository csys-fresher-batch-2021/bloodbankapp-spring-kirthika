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
			<h3>Donor Form</h3>
		</div>
		<form action="AddDonorServlet" method="post">

			<div class="d-flex justify-content-center">
				<label for="donorName"></label> <input type="text" name="donorName"
					placeholder="Enter donor name" required autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">
				<label for="bloodGroup"></label> <select name="bloodGroup" required>
					<option>----Blood type----</option>
					<option value="A+">A+</option>
					<option value="A-">A-</option>
					<option value="B+">B+</option>
					<option value="B-">B-</option>
					<option value="O+">O+</option>
					<option value="O-">O-</option>

				</select>
			</div>

			<br />
			<div class="d-flex justify-content-center">
				<label for="mobileNumber"></label> <input type="number"
					name="mobileNumber" placeholder="Enter mobile number" required
					autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">
				<label for="age"></label> <input type="number" name="age"
					placeholder="Enter age" required autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">



				<select name="place" required>
					<option>Enter district</option>
					<option value="Ariyalur">Ariyalur</option>
					<option value="Chennai">Chennai</option>
					<option value="Coimbatore">Coimbatore</option>
					<option value="Erode">Erode</option>
					<option value="Salem">Salem</option>
					<option value="Thanjavur">Thanjavur</option>
					<option value="Trichy">Trichy</option>
					<option value="Vellore">Vellore</option>
					<option value="Villupuram">Villupuram</option>
					<option value="Virudhunagar">Virudhunagar</option>
				</select>
			</div>
			<br />

			<%
			String message = request.getParameter("errorMessage");
			if (message == null) {
				out.print("");
			} 
			else if(message.equals("Donor added"))
			{   
				out.print("<font color='green'><center>" + message + "</font>");
				
			}
			else {
				out.print("<font color='red'><center>" + message + "</font>");
			}
			%>
			<br /> <br />
			<%
				if (loggedInUsername.equalsIgnoreCase("admin")) {
				%>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Add donor</button>
			</div>
			<%} else {%>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Register
					Donor</button>
			</div>
			<%} %>
		</form>

	</main>
</body>
</html>