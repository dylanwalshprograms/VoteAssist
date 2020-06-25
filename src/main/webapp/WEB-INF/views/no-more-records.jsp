<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No More Records</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/login-and-sign-up.css" rel="stylesheet" />
</head>
<body>
	<nav class="navbar bg-light">
	
		<img alt="vote-assist-logo" src="VoteAssistLogo.png" class="img-icon">
		
		<form action="/reset-time">
			<input type="datetime-local" name="time">
			<button class="btn btn-dark">Change "Current" Date</button>
		</form>
		
		<label>"Current" Date: ${timeMachineString}</label>
		
		<div>
			<a type="button" class="btn btn-warning" href="/contact-admin" target="popup" onclick="window.open('/contact-admin','Email','width=600,height=525')">Contact Admin</a>
			<a type="button" class="btn btn-danger" href="/logout">Logout</a>
		</div>
	</nav>
	<div class="records">
	<main>
	<article class="card mx-auto">

			<section class="card-header">

				<h1>No More Records</h1>

			</section>

			<section class="card-body">

				<p>You've reached the end of the available records.</p>
				<p>We thank you for your dedication and hard work.</p>
				<p>If you would like to continue please use our time machine to pull records that are scheduled for the future.</p>
				<p class="disclaimer">*Please note that this is for demo purposes only. We do not actually have the capability to go to the future.</p>

			</section>

		</article>

	</main>
	</div>
</body>
</html>