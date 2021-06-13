<!DOCTYPE>
<%@page import="in.kirthika.dao.SeekerManagerDao"%>
<%@page import="in.kirthika.model.SeekerDetail"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.kirthika.service.SeekerManager"%>
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Seeker Details</h3>
		<form>

			<br />
			<table class="table table-bordered">
				<caption>Seeker Details</caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Seeker Name</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Blood Group</th>
						<th scope="col">Age</th>
						<th scope="col">Place</th>
						<th scope="col">Request Date</th>
						<th scope="col">Gender</th>
						<th scope="col">Status</th>

					</tr>

				</thead>
				<tbody>
					<%
					SeekerManager manager = new SeekerManager();
					List<SeekerDetail> taskList = manager.displaySeekerList();
					int i = 0;
					for (SeekerDetail detail : taskList) {

						i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><%=detail.getName()%></td>
						<td><%=detail.getMobileNumber()%></td>
						<td><%=detail.getBloodGroup()%></td>
						<td><%=detail.getAge()%></td>
						<td><%=detail.getPlace()%></td>
						<td><%=detail.getDate()%></td>
						<td><%=detail.getGender()%></td>
						<td><%=detail.getStatus()%>
						<td><a
							href="ApproveServlet?mobileNumber=<%=detail.getMobileNumber()%>&receiverName=<%=detail.getName()%>"
							class="btn btn-success">Approve</a></td>

					</tr>
					<%
					}
					%>


				</tbody>
			</table>
		</form>


	</main>
</body>
</html>
