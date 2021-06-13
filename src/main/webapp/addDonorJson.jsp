<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Donor</title>
<%
String loggedInUsername = (String) session.getAttribute("LOGIN_USER");
%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>Donor Form</h3>
		</div>
		<form onsubmit="addDonor()">

			<div class="d-flex justify-content-center">
				<label for="donorName"></label> <input type="text" name="donorName"
					id="donorName" placeholder="Enter donor name" required autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">
				<label for="bloodGroup"></label> <select name="bloodGroup"
					id="bloodGroup" required>
					<option>----Blood type----</option>
					<option value="A+">A+</option>
					<option value="A-">A-</option>
					<option value="B+">B+</option>
					<option value="B-">B-</option>
					<option value="O+">O+</option>
					<option value="O-">O-</option>

				</select>
			</div>

			<br />

			<div class="d-flex justify-content-center">
				<label for="mobileNumber"></label> <input type="number"
					id="mobileNumber" name="mobileNumber"
					placeholder="Enter mobile number" required autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">
				<label for="age"></label> <input type="number" name="age" id="age"
					placeholder="Enter age" required autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">



				<select name="place" id="place" required>
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
			<br />
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Add donor</button>
			</div>

			<label for="display" id="display"></label> <br />

		</form>
		<script>
		function addDonor(){
			event.preventDefault();
			
			let donorName=document.querySelector("#donorName").value;
			let donorBlood=document.querySelector("#bloodGroup").value;
			let donorNumber=document.querySelector("#mobileNumber").value;
			let donorAge=document.querySelector("#age").value;
			let donorPlace=document.querySelector("#place").value;
			
			const queryParams="?donorName="+donorName+ "&donorBlood=" +donorBlood+ "&donorNumber=" +donorNumber+
					"&donorAge="+donorAge+ "&donorPlace="+donorPlace;
			const formData={"donorName":donorName,"donorBlood":donorBlood,"donorNumber":donorNumber,"donorAge":donorAge,"donorPlace":donorPlace};
			console.log(formData);
			let url="AddDonorJson"+queryParams;
			fetch(url).then(res=>res.json()).then(res=>{
			
				let result=res;
				console.log(result);
				
				if(result.infoMessage !=null){
					 message=result.infoMessage;
					 let params=new URLSearchParams(window.location.search);
				     let name=params.get('infoMessage');
				     
					 document.getElementById('display').innerHTML=message;
					
					
				}
				else{
					message=result.errorMessage;
					 let params=new URLSearchParams(window.location.search);
				     let name=params.get('errorMessage');
				     document.getElementById('display').innerHTML=message;
					
				}
				
				 
			});
		}
		</script>

	</main>
</body>
</html>