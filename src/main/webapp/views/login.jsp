<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
	integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
	crossorigin="anonymous"></script>
<title>Sign in</title>
</head>
<body class="text-center">
	<div class="container mt-5 w-50">
		<div class="jumbotron">
			<h1 class="display-4" align="left">Sign in</h1>
			<br />
			<div class="container">
				<form action="login" method="post" class="justify-content-center">
					<div class="container w-25">
						<div class="row mb-3">
							<label for="username">Username</label>
							<input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
						</div>
						<div class="row mb-3">
							<label for="password">Password</label>
							<input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
						</div>
						<div class="row mb-3 justify-content-center">
							<c:if test="${param.error ne null && param.error != ''}">
								<div class="alert alert-danger py-1 m-0" role="alert" id="errorMsg">${param.error}</div>
							</c:if>
						</div>
						<div class="form-group w-100 text-center">
							<button type="submit" id="submitLogin" class="btn btn-primary w-75">Sign in</button>
						</div> 
					</div> 
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>