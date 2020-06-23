<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Reset</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>
<div>
	<img alt="vote-assist-logo" src="VoteAssistLogo.png" class="img-centered">
</div>
	<article class="card mx-auto">
		<section class="card-header">${message}</section>

		<section class="card-body">
			<div>

				<form action="/reset-password/submit">
					<div class="form-group">
						<label>Password</label> <input class="form-control"
							name="password" type="password" required />
					</div>

					<div class="form-group">
						<label>Confirm Password</label> <input class="form-control"
							name="passwordConfirm" type="password" required />
					</div>

					<button class="btn btn-primary">Reset Password</button>
				</form>
			</div>
		</section>
	</article>
</body>
</html>