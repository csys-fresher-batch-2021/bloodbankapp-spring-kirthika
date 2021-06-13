<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<%
String loggedInUsername = (String) session.getAttribute("LOGIN_USER");
%>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">

		<a class="navbar-brand" href="#">Blood Bank App</a>


		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<%
					if (loggedInUsername!=null && loggedInUsername.equals("admin")){
					%>
				<li class="nav-item active"><a class="nav-link"
					href="addDonor.jsp">Add Donor<span class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="donorSearchPage.jsp">Search Donor<span class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="deleteDonorDetail.jsp">Delete Donor<span class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="displayDonor.jsp">Display Donor<span class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="seekerRequest.jsp">Seeker Request<span class="sr-only">(current)</span></a></li>
					
				<li class="nav-item active"><a class="nav-link"
					href="stockManagement.jsp">Stock Records<span class="sr-only">(current)</span></a></li>

				<%}else if(loggedInUsername!=null && !loggedInUsername.equals("admin")){%>
				<li class="nav-item active"><a class="nav-link"
					href="addDonor.jsp">Donor Registration form<span
						class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="registrationForm.jsp">Seeker Registration form<span
						class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"
					href="seekerStatus.jsp">Seeker Status<span class="sr-only">(current)</span></a></li>

				<%} %>
			</ul>
		</div>
		<%
		if (loggedInUsername == null) {
		%>
		<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="dropdownId"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">SignIn</a>
				<div class="dropdown-menu" aria-labelledby="dropdownId">
					<a class="dropdown-item" href="userSignIn.jsp">User Login</a> <a
						class="dropdown-item" href="login.jsp">Admin Login</a>
				</div></li>

			<li class="nav-item active"><a class="nav-link"
				href="register.jsp">Register</a></li>
		</ul>

		<%
		} else {
		%>



		<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="#">Welcome<%=" " + loggedInUsername%></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
			</li>
		</ul>

		<%
		}
		%>



	</nav>
</header>
