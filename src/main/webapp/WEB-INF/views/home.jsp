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
<div class="voter-data">
<p>
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
</p>
</div>
<div class="accordian" id="accordianExample">
	<div class="card">
		<div class="card-header" id="headingOne">
			 <h2 class="mb-0">
			 	<button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			 	 Voter local election data
			 	</button>
			 </h2>
		</div>
		<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      		<div class="card-body">
      					
      		 
      		</div>
      	</div>	 	 
	</div>
	<div class="card">
    	<div class="card-header" id="headingTwo">
      		<h2 class="mb-0">
        		<button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
         		 Representative data
        		</button>
      		</h2>
   		 </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      	<div class="card-body">
      	
      	</div>
    	</div>
	</div>
</div> 
<table>
      			<tr>
      			<th>Official's Name</th>
      			<th>Official's Address</th>
      			<th>Official's Party</th>
      			<th>Official's Email Address</th>
      			</tr>
      			<tr>
      			<c:forEach items="${civicResponse.offices}" var="office">
      				
      					<td><c:out value="${office.name}"/></td>
      					
      						<c:forEach items="${office.officialIndices}" var="index">
      							<td>
	      							<ul>
		      							<li>
		      								<c:out value="${civicResponse.officials.get(index).name}"/>
		      							</li>
	      							</ul>
      							</td>
      						</c:forEach>
      					
      					<td><c:out value="${official.address}"/></td>
      					<td><c:out value="${official.party}"/></td>
      					<td><c:out value="${official.emails}"/></td>
      				</c:forEach>
      			
      			</tr>	
      			</table>       

<!-- <p>${ civicResponse }</p>  -->
<!-- <p>${ civicResponse.normalizedInput }</p>  -->
<!-- <p>${ civicResponse.offices }</p>  -->
<!-- <p>${ civicResponse.officials }</p> -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>