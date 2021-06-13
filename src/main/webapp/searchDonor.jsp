<!DOCTYPE>
<%@page import="in.kirthika.model.DonorDetail"%>
<%@page import="in.kirthika.dao.DonorManagerDao"%>
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
		<table class="table table-bordered">
			<caption>Donor Details</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Donor Name</th>
					<th scope="col">Mobile Number</th>
					<th scope="col">Blood Group</th>
					<th scope="col">Age</th>
					<th scope="col">Place</th>

				</tr>

			</thead>
			<tbody>
				<%
	      DonorManagerDao manager=new DonorManagerDao();
	      List<DonorDetail> taskList=manager.allSearchDonorList();
	      int i=0;
	      for(DonorDetail detail:taskList)
	      {
	      
	    	  i++;
	      
	    %>
				<tr>
					<td><%=i %></td>
					<td><%=detail.getName() %></td>
					<td><%=detail.getMobileNumber() %></td>
					<td><%=detail.getBloodGroup()%></td>
					<td><%=detail.getAge() %></td>
					<td><%=detail.getPlace()%></td>

				</tr>
				<%}
	     %>

			</tbody>
		</table>

		<a href="donorSearchPage.jsp">search donor</a> <br /> <br /> <a
			href="adminManager.jsp">Back to homepage</a>


	</main>
</body>
</html>
