<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>
	<article class="card mx-auto">

			<section class="card-header">

				<h4>
					<c:out value="${message}" />
				</h4>

			</section>

			<section class="card-body">

				<form action="/login/submit" method = "post">

					<div class="form-group">
						<label>Name</label> <input class="form-control"
							name="name" type="text" required />

					</div>

					<div class="form-group">
						<label>Username</label> <input class="form-control"
							name="userName" type="text" required />

					</div>

					<div class="form-group">
						<label>Password</label> <input class="form-control"
							name="password" type="password" required />
					</div>

					<button class="btn btn-block btn-secondary">Login</button>

				</form>
				
				<a href="/signup">Sign Up</a>

			</section>

		</article>

	</main>
</body>
</html>