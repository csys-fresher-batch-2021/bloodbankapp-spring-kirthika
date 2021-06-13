<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>Register as a Seeker</h3>
		</div>


		<form action="SeekerServlet" method="post">
			<div class="row">
				<div class="col">
					<label>Donor Name</label><input type="text" name="receiverName"
						class="form-control form-control-sm"
						placeholder="Enter receiver name" required>
				</div>
				<div class=" col">
					<label>Mobile Number</label><input type="number"
						name="mobileNumber" min="0000000000" max="9999999999"
						id="Mobile-Number" class="form-control form-control-sm"
						placeholder="Mobile Number" required>
				</div>
				<div class="col">
					<label>Blood Group</label> <select name="bloodGroup"
						class="form-control form-control-sm" required>
						<option>----Blood type----</option>
						<option value="A+">A+</option>
						<option value="A-">A-</option>
						<option value="B+">B+</option>
						<option value="B-">B-</option>
						<option value="O+">O+</option>
						<option value="O-">O-</option>
					</select>


				</div>
			</div>

			<br />
			<div class="row">



				<div class="col">
					<label>Required Date</label><input type="date" name="date"
						class="form-control form-control-sm" value="<%=LocalDate.now()%>"
						placeholder="YYYY-MM-DD" required>
				</div>

				<div class="col">
					<label>District</label><select name="place"
						class="form-control form-control-sm" required>
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
				<div class="col">
					<label for="age">Age</label> <input type="number" name="age"
						placeholder="Enter age" class="form-control form-control-sm"
						required autofocus />
				</div>

			</div>
			<div class="row">
				<div class="col">
					<label>Gender</label>
					<div class="form-check form-check-inline">
						<label>Male</label><input type="radio" id="Male" name="gender"
							value="Male" required>
					</div>
					<div class="form-check form-check-inline">
						<label>Female</label><input type="radio" id="Female" name="gender"
							value="Female" required>
					</div>
				</div>
			</div>

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

			<div class="row">
				<div class="form-group col-md-2">
					<button class="btn btn-success">Register</button>
					<br>
				</div>
				<div class="form-group col-md-2">
					<button type="reset" class="btn btn-danger">Reset</button>
				</div>



			</div>


			<br />


		</form>

	</main>
</html>