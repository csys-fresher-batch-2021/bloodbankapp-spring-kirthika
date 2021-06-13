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


		<br /> <br />
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
			<tbody id="donorDetail">
			</tbody>
		</table>
		<script>
	    function getAllDonor(){
	    	console.log("Fetching all Details");
	    	
	    	let url = "DisplayDonorjson";
	    	fetch(url).then(res=> res.json()).then(res=>{
	    		let detail=res;
	    		console.log(res);
	    		let i=0;
	    		let content="";
	    		for(let details of detail){
	    			content +=
	    				"<tr><td>"+ ++i +"</td><td>"+details.bloodGroup+"</td><td>"+details.name+"</td><td>"+details.mobileNumber+"</td><td>"+details.age+"</td><td>"+details.place+"</td></tr>";
	    		}
	    		
	    		document.querySelector('#donorDetail').innerHTML=content;
	    	})
	    	

	    }
	    getAllDonor();
	    </script>
	</main>
</body>
</html>



