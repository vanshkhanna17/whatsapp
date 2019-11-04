<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
	<title>Let's VaartaLaap</title>
</head>

<body class="body">

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img src="https://www.inmatephones.ca/wp-content/uploads/2014/04/voice-message-icon.png">
			</div>
			<div class="col-md-8 r1">
				<div class="row">
					<h1>Welcome to VaartaLaap</h1>
				</div>
				<div class="row line"></div>
				<div class="row">
					<h3>Already a member? Login here!!!</h3>
				</div>
				<div class="row">
					<form novalidate action="login" method="post" class="form-row" id="loginForm">
						<div class="form-group">
							<label for="uname" class="col-form-label">Email</label> <input type="text" name="uname"
								placeholder="Email" class="form-control">
						</div>&nbsp;&nbsp;&nbsp;
						<div class="form-group">
							<label for="password" class="col-form-label">Password</label> <input type="password"
								name="password" placeholder="Password" class="form-control">
						</div>&nbsp;&nbsp;&nbsp;
						<div class="form-group">
							<button type="submit" class="btn btn-primary bt1">Login</button>
						</div>
					</form>
					<c:if test="${ wrongpass eq true }">
						<p class="small">Wrong Email ID or Password</p>
					</c:if>
				</div>
				<div class="row line"></div>
				<div class="row">
					<h3>Not a member? Sign-up here!!!</h3>
				</div>
				<div class="row">
					<form novalidate action="register" method="post" id="registerForm">
						<div class="form-row">
								<div class="form-group">
										<label for="firstname" class="col-form-label">First Name</label> <input type="text" name="firstname"
											placeholder="First Name" class="form-control">
									</div>&nbsp;&nbsp;
									<div class="form-group">
											<label for="lastname" class="col-form-label">Last Name</label> <input type="text" name="lastname"
												placeholder="Last Name" class="form-control">
										</div>
						</div>
						<div class="form-group">
							<label for="uname" class="col-form-label">Email</label> <input type="text" name="uname"
								placeholder="Email" class="form-control">
						</div>
						<div class="form-group">
							<label for="password" class="col-form-label">Password</label> <input type="password"
								name="password" id="password" placeholder="Password" class="form-control">
						</div>
						<div class="form-group">
							<label for="cpassword" class="col-form-label">Confirm Password</label> <input
								type="password" name="cpassword" placeholder="Confirm Password" class="form-control">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Sign-Up</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="js/script.js"></script>
</body>

</html>