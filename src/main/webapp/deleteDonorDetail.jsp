<!DOCTYPE>
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
				<th scope="col">Delete</th>
		</tr>
				
		</thead>
	    <tbody>
	    <%
	      DonorManagerDao manager=new DonorManagerDao();
	      List<DonorDetail> taskList=manager.allDonorList();
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
			    <td><a href="DeleteDonorServlet?mobileNumber=<%=detail.getMobileNumber() %>&donorName=<%=detail.getName() %>"
			      class="btn btn-danger">Delete</a></td>
			          
			</tr>
	     <%}
	     %>
	    
	   </tbody>
	  </table>
		
		<a href="addDonor.jsp">Add Donor</a>
		<br/>
		<br/>
		<a href="adminManager.jsp">Back to homepage</a>

</main>
</body>
</html>