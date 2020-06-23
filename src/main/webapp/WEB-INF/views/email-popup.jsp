<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send email to voter</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

								<div class="card-body">
									<form action="/send-email">
										<label>To:</label><br>
										<input type="email" name="toEmail" required width="200%"><br>
										<input type="hidden" name="fromEmail" value="voteassist.admn@gmail.com">
										<label>Subject:</label><br>
										<textarea rows="1" cols="75" name="subject">Vote by Mail with VoteAssist!</textarea><br>
										<label>Message:</label><br>
										<textarea rows="10" cols="75" name="contentString" required>
[ADD YOUR PERSONAL MESSAGE HERE!]

Thanks for taking the time to speak with our volunteer today.
You can get detailed instructions of voting by mail in your area at turbovote.org


	Thanks again,
	VoteAssist
										</textarea><br>
										<button class="btn btn-success">Send</button>
									</form>
								</div>


</body>
</html>