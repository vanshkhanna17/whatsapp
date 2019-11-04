<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div>
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand" href="afterlogin.jsp">VaartaLaap</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="group.jsp">My groups</a></li>
						<li class="nav-item"><a class="nav-link" href="msg.jsp">Messages</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Create
								Group<span class="sr-only">(current)</span>
						</a></li>
				</div>
			</nav>
		</div>
	</div>
	<div class="container">
		<form action="crtgrp" method="post">
			<input type="text" name="gname" class="form-control"
				placeholder="Group Name">
			<table class="table">
				<thead class="thead thead-dark">
					<th>Users</th>
					<th>Select Users</th>
				</thead>
				<tbody>
					<c:forEach var="u" items="${users}">
						<tr><td>${u.name}</td>
						<td><input type="checkbox" name="chk" value="${u.id}">
						</td></tr>
					</c:forEach>
					<button type="submit" class="btn btn-primary">Create Group</button>
					</form>
				</tbody>
			</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="js/script.js"></script>
</body>
</html>