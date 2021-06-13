<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="in.kirthika.service.DonorManager"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Blood Records</title>
<%
String loggedInUsername = (String) session.getAttribute("LOGIN_USER");
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>Blood Records</h3>
			<br /> <br />
		</div>
		<form onsubmit="display()">

			<div class="d-flex justify-content-center">



				<select name="stockPlace" id="stockPlace" required>
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
			<br /> <br />
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Check</button>
			</div>

			<br /> <br />

			<table class="table table-bordered">
				<caption>Donor Details</caption>
				<thead>
					<tr>

						<th scope="col">Donor blood</th>
						<th scope="col">No of donor</th>

					</tr>
				</thead>
				<tbody id="donorDetail">
				</tbody>
			</table>
			<script>
		function display(){
			event.preventDefault();
			let stockPlace=document.querySelector("#stockPlace").value;
			
			
			const queryParams="?stockPlace="+stockPlace;
					
			const formData={"stockPlace":stockPlace};
			console.log(formData);
			let url="StockManagementServlet"+queryParams;
		
			fetch(url).then(res=>res.json()).then(res=>{
				
				let data = res;
				let length=( Object.keys( data.stockCount).length ) ;
				
				let content="";
				if(length!=0){
				for(let bloodGroup in data.stockCount){
					     
						 console.log(bloodGroup);
						 content += "<tr><td>"+bloodGroup+"</td><td>"+data.stockCount[bloodGroup]+"</td></tr>";
						
					}
				}
				else{
					
					content+="<tr><td colspan=2 class='text-center'>" + "<font color='red'>No Records Found</font>" + "</td></tr>"; 
				}
				 document.querySelector('#donorDetail').innerHTML=content;
		});
			}
		</script>


		</form>

	</main>
</body>
</html>
