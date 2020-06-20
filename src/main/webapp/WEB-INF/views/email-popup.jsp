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
									<form action="/send-email">
										<label>To:</label>
										<input type="text" name="toEmail" required><br>
										<label>Subject:</label>
										<input type="text" name="subject"><br>
										<label>Message:</label>
										<textarea rows="3" cols="12" name="contentString" required></textarea><br>
										<button>Send</button>
									</form>
								</div>


</body>
</html>