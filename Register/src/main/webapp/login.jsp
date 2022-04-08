<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

 <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            

</head>
<body style ="background: url(img/luggage-1149289_1920.jpg);background-size:cover;background-attachment : fixed;">
		
	<div class = "contianer">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<h3 style="margin-top : 10px;" class="center-align">Login Here!!</h3>
					
						<div class="form center-align">
						<!-- form -->     
							<form action ="loginServlet" method ="POST">
								
								<input type="email" name="user_email" placeholder ="Enter Email">
								<input type="password" name="user_password" placeholder ="Enter Password">
					
								 
								<button type ="submit" class="btn" >
									Login
								</button>
							
							
							</form>
							<div>
								<div class="loader centre-align" style="margin-top:10px; display:none;" >
									 <div class="progress">
   										   <div class="indeterminate"></div>
  									</div>
        						<h5>Please Wait.....</h5>
								</div>
							</div>
							
						</div>	
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<!-- jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!-- <script>
		$(document).ready(function() {
			console.log("page is ready");
			})
	</script> -->
</body>
</html>