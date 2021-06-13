<!DOCTYPE>
<%@page import="in.kirthika.model.SeekerStatusDetail"%>
<%@page import="in.kirthika.service.SeekerManager"%>
<%@page import="in.kirthika.dao.DonorManagerDao"%>
<%@page import="in.kirthika.model.DonorDetail"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.kirthika.service.DonorManager"%>

<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Donor Details</h3>

		<br />
		<form>
			<label for="display" id="name"></label> <br /> <label for="display"
				id="number"></label> <br /> <label for="display" id="status"></label>
			<br />

			<table class="table table-bordered">
				<caption>Donor Details</caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Donor name</th>
						<th scope="col">Donor Place</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Donor Blood</th>

					</tr>

				</thead>
				<tbody>
					<%
	      SeekerManager manager=new SeekerManager();
	      List<SeekerStatusDetail> taskList=manager.displayDonor();
	      int i=0;
	      for(SeekerStatusDetail detail:taskList)
	      {
	      
	    	  i++;
	      
	    %>
					<tr>
						<td><%=i %></td>
						<td><%=detail.getName() %></td>
						<td><%=detail.getPlace() %></td>
						<td><%=detail.getMobileNumber()%></td>
						<td><%=detail.getBlood() %></td>


					</tr>
					<%}
	     %>

				</tbody>
			</table>
			<script>
	     {
	        let params=new URLSearchParams(window.location.search);
	        let name=params.get('name');
	        let number=params.get('number')
	        let status=params.get('status');
	        document.getElementById('name').innerHTML="Seeker Name: "+name;
	        document.getElementById('number').innerHTML="Seeker Mobile Number: "+number;
	        document.getElementById('status').innerHTML="Seeker Status: "+status;
	     }
	  
	  </script>
		</form>


	</main>
</body>
</html>
