<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Call Log</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/static/style.css" rel="stylesheet" />
</head>
<body>
	<nav class="navbar bg-light">
					
		<ul class="nav">
			
			<li class="nav-item">
				<a class="nav-link" href="/logout">Logout</a>
			</li>
			<li>
				<form class="form-inline my-2 my-lg-0" action = "/call-log">
      				<input class="form-control mr-sm-2" type="search" value="${param.keyword}" name="keyword" placeholder="Search by Result" aria-label="Search">
      				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    			</form>	
			<li>
		</ul>
	</nav>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Volunteer Id</th>
      <th scope="col">Voter Id</th>
      <th scope="col">Call Time</th>
      <th scope="col">Next Call Time</th>
      <th scope="col">Result</th>
      <th scope="col">Notes</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="call" items="${callLog}">
    <tr>
      <td><c:out value="${call.volunteer.id}"/></td>
      <td><c:out value="${call.voterData.id}"/></td>
      <td><c:out value="${call.callTime}"/></td>
      <td><c:out value="${call.nextCall}"/></td>
      <td><c:out value="${call.result}"/></td>
      <td><c:out value="${call.notes}"/></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</body>
</html>