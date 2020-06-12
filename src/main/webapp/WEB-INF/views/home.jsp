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

<p>
	<c:forEach items="${ voterData }" var="voter">
		<p>${ voter.name }</p>
		<p>${ voter.phone }</p>
		<p>${ voter.address }</p>
		<p>${ voter.city }</p>
		<p>${ voter.state }</p>
		<p>${ voter.zip }</p>
		<p>${ voter.partyPref }</p>
		<p>${ voter.voteByMail }</p>
		<p>${ voter.nextCall }</p>
		<p>${ voter.lastCall }</p>
		<p>${ voter.notes }</p>
		<p>${ voter.result }</p>
		
		
		
		
	</c:forEach>
</p>

<p>${ civicResponse }</p>
<p>${ civicResponse.normalizedInput }</p>
<p>${ civicResponse.offices }</p>
<p>${ civicResponse.officials }</p>

</body>
</html>