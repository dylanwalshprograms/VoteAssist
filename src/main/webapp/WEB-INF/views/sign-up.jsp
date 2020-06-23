<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/login-and-sign-up.css" rel="stylesheet" />
</head>
<body>
<main>
<div class="sign-up">
	<article class="card mx-auto">

			<section class="card-header">

				<h1>Volunteer Sign Up</h1>

			</section>

			<section class="card-body">

				<form action="/sign-up/submit" method = "post">
				
					<c:out value="${message}" />

					<div class="form-group">
						<label>Name</label> <input class="form-control"
							name="name" type="text" required />

					</div>
					
					<div class="form-group">
						<label>Email</label> <input class="form-control"
							name="email" type="email" required />

					</div>

					<div class="form-group">
						<label>Username</label> <input class="form-control"
							name="userName" type="text" required />

					</div>

					<div class="form-group">
						<label>Password</label> <input class="form-control"
							name="password" type="password" required />
					</div>
					
					<div class="form-group">
						<label>Confirm Password</label> <input class="form-control"
							name="passwordConfirm" type="password" required />
					</div>

					<button class="btn btn-block btn-secondary">Sign up</button>

				</form>

			</section>

		</article>

	</main>
</div>
</body>
</html>