<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>User Sign up</h3>
		</div>
		<form action="UserRegistration" method="post">

			<div class="d-flex justify-content-center">
				<label for="userName"></label> <input type="text" name="userName"
					placeholder="Enter User name" required autofocus />
			</div>
			<br />
			<div class="d-flex justify-content-center">
				<label for="password"></label> <input type="password"
					name="password" placeholder="Create password" required autofocus />
			</div>
			<br />



			<div class="d-flex justify-content-center">
				<label for="mobileNumber"></label> <input type="number"
					name="mobileNumber" placeholder="Enter mobile number" required
					autofocus />
			</div>


			<br />



			<%
			String message = request.getParameter("message");
			if (message == null) {
				out.print("");
			} 
			else if(message.equals("Registration Successful"))
			{   
				out.print("<font color='green'><center>" + message + "</font>");
				
			}
			else {
				out.print("<font color='red'><center>" + message + "</font>");
			}
			%>
			<br /> <br />

			<div class=" row =2 d-flex justify-content-center ">
				<div class="col-1">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
				<div class="col-1">
					<button type="reset" class="btn btn-danger">Reset</button>
				</div>
			</div>

		</form>
	</main>