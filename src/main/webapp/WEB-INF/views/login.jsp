<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/login-and-sign-up.css"  rel="stylesheet" />
</head>
<body>
<main>

<div>
	<img alt="vote-assist-logo" src="VoteAssistLogo.png" class="img-centered">
</div>

<div class="login">
	<article class="card mx-auto">

			<section class="card-header">

				<h1>Volunteer Login</h1>

			</section>

			<section class="card-body">

				<form action="/login/submit" method = "post">
				
					<c:out value="${message}" />

					<div class="form-group">
						<label>Username</label> <input class="form-control"
							name="userName" type="text" required />

					</div>

					<div class="form-group">
						<label>Password</label> <input class="form-control"
							name="password" type="password" required />
					</div>

					<button class="btn btn-block btn-secondary" name="loginType" value="volunteer">Login as Volunteer</button><button class="btn btn-block btn-secondary" name="loginType" value="admin">Login as Admin</button>

				</form>
				
				<a class="btn btn-primary" href="/sign-up">Sign Up</a>
				
				<a type="button" class="btn btn-dark" href="/forgot-password" target="popup" onclick="window.open('/forgot-password','Forgot Password?','width=750,height=600')">Forgot Password?</a>
				

			</section>

		</article>

	</main>
</div>
</body>
</html>