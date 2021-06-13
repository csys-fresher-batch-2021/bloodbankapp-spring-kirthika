<!DOCTYPE html>
<html lang="en">
<head>
<title>Blood Bank</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>Blood Bank</h3>
		</div>
		<div class="d-flex justify-content-center">
			<h3>User Sign in</h3>
		</div>
		<form action="UserLoginServlet" method="Post">
			<div class="d-flex justify-content-center">
			<div class="col-4">
				<label for="userName"></label> 
				<input type="text" name="userName" placeholder="Enter User Name" class="form-control form-control-sm" required autofocus />
				</div>
			</div>
			<br />
			<div class="d-flex justify-content-center">
			<div class="col-4">
				<label for="Password"></label> 
				<input type="password" name="password" placeholder="Enter password" class="form-control form-control-sm" required autofocus />
                </div>
			</div>
			<br />

			<div class="d-flex justify-content-center">
				<div class="col-1">
            <button type="submit" class="btn btn-success">Login</button>
                </div>
                <div class=" col-1">
            <button type="reset" class="btn btn-danger">Reset</button>
			    </div>
			</div>
			


			<br />

		</form>
		<%
		String message = request.getParameter("message");
		if (message == null) {
		out.print("");
		} 
		else {

			out.print("<font color='red'><center>" + message + "</font>");
		}
		%>
		

	</main>

</body>
</html>
