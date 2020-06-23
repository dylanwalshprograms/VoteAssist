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

								<div class="card-body">
									<form action="/send-admin-email">
										<label>Your Email:</label><br>
										<input type="email" name="returnAddress">
										<input type="hidden" name="fromEmail" value="voteassist.admn@gmail.com">
										<input type="hidden" name="toEmail" value="voteassist.admn@gmail.com">
										<label>Subject:</label><br>
										<textarea rows="1" cols="75" name="subject">VOLUNTEER REQUEST</textarea><br>
										<label>Message:</label><br>
										<textarea rows="10" cols="75" name="contentString" required>
[ADD YOUR PERSONAL MESSAGE HERE!]


										</textarea><br>
										<button class="btn btn-success">Send</button>
									</form>
								</div>


</body>
</html>