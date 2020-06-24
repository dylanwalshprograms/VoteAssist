<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote Assist</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/static/style.css" rel="stylesheet" />

</head>
<body>



	<nav class="navbar bg-light">
		
		<form action="/reset-time">
			<input type="datetime-local" name="time">
			<button class="btn btn-dark">Change "Current" Date</button>
		</form>
		
		<img alt="vote-assist-logo" src="VoteAssistLogo.png" class="img-icon img-centered">
		
		<label>"Current" Date: ${timeMachineString}</label>
		
				<a type="button" class="btn btn-warning" href="/contact-admin" target="popup" onclick="window.open('/contact-admin','Email','width=600,height=525')">Contact Admin</a>
		
		<ul class="nav">
			
			
		</ul>
	</nav>
	<div class="top left">
		<main class="container">

			<article class="card mx-auto">

				<section class="card-header">
					<h1>Voter Information</h1>
				</section>

				<section class="card-body">

					Name - ${voterInformation.voterData.name}<br> 
					Phone - ${voterInformation.voterData.phone}<br>
					Street Address - ${voterInformation.voterData.address}<br> 
					City - ${voterInformation.voterData.city}<br>
					State - ${voterInformation.voterData.state}<br> 
					Zip Code - ${voterInformation.voterData.zip}<br>
					Party Preference - ${voterInformation.voterData.partyPref}<br> 
					Is this person voting by mail? - ${voterInformation.voterData.voteByMail}<br> 
					Next Scheduled Call - ${voterInformation.getNextCallInWords()}<br> 
					Last Call - ${voterInformation.getLastCallInWords()}<br>
					Last Call Result - ${voterInformation.voterData.result}<br>

				</section>
				
				<a type="button" class="btn btn-primary" href="/email-popup" target="popup" onclick="window.open('/email-popup','Email','width=600,height=525')">Send Email to Voter</a>

			</article>

		</main>
	</div>

	<div class="top right">

        <main class="container">

            <article class="card mx-auto">

                <section class="card-header">

                    <h1>Comments</h1>

                </section>

                <section class="card-body">

	<form action="/submit">
		<div>
			<textarea class="note-text" rows="3" name="notes"></textarea>
		</div>
		<div>
			<input type = "hidden"name = "voterId" value = "${voterInformation.voterData.id}">

			<input type="radio" id="NA" name="result" value="NA" required>
			<label for="NA">No Answer/Voicemail</label><br> 
			<input type="radio" id="RQ" name="result" value="RQ"> 
			<label for="RQ">Requested Callback</label>
			<input type="datetime-local" name="nextCall"><br> 
			<input type="radio" id="VIP" name="result" value="VIP"> 
			<label for="VIP">Will Vote in Person</label><br> 
			<input type="radio" id="WVBM" name="result" value="WVBM"> 
			<label for="WVBM">Will Register to Vote by Mail</label><br>
			<input type="radio" id="AVBM" name="result" value="AVBM">
			<label for="AVBM">Already Registered to Vote by Mail</label><br> 
			<input type="radio" id="NV" name="result" value="NV"> 
			<label for="NV">Not Voting</label><br> 
			<input type="radio" id="DNC" name="result" value="DNC"> 
			<label for="DNC">Do Not Call</label><br>
		</div>
		<div>
			<button class="btn btn-success" name="button" value="next">Submit/NEXT</button>
			<button class="btn btn-danger" name="button" value="end">Submit/LOGOUT</button>
		</div>
	</form>

                </section>

            </article>

        </main>
	</div>
        
        <div class="bottom left">
                <main class="container">

            <article class="card mx-auto">

                <section class="card-header">

                   <!-- <c:set var="main-script" value="${script}"/>
                <c:if test = "${script == 'main-script'}">
					<h1>Main Script</h1>
					</c:if>
					<c:set var="vip-reminder-script" value="${script}"/>
                <c:if test = "${script == 'vip-reminder-script'}">
					<h1>Voting in Person Script</h1>
					</c:if>
					<c:set var="vbm-reminder-script" value="${script}"/>
                <c:if test = "${script == 'vbm-reminder-script'}">
					<h1>Will Vote by Mail Script</h1>
					</c:if> -->


                </section>

                <section class="card-body">

					<c:out value="${template}"/>

                </section>

            </article>

        	</main>
        </div>
	<div class="bottom right">
		<main class="login container">
			<article class="card mx-auto">
				<section class="card-header">
					<h1>Additional Information</h1>
				</section>
				<section class="card-body">
					<div class="accordion" id="accordionExample">
						<div class="card">
							<div class="card-header" id="headingTwo">
      							<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
										Previous Call History
									</button>
								</h2>
							</div>
							<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
								<div class="card-body">
									<table class="table">
									  <thead>
									    <tr>
									      <th scope="col">Volunteer Name</th>
									      <th scope="col">Call Time</th>
									      <th scope="col">Next Call Time</th>
									      <th scope="col">Result</th>
									      <th scope="col">Notes</th>
									    </tr>
									  </thead>
									  <tbody>
									  	<c:forEach var="call" items="${callLog}">
									    <tr>
									      <td><c:out value="${call.volunteer.name}"/></th>
									      <td><c:out value="${call.callTime}"/></td>
									      <td><c:out value="${call.nextCall}"/></td>
									      <td><c:out value="${call.result}"/></td>
									      <td><c:out value="${call.notes}"/></td>
									    </tr>
									    </c:forEach>
									  </tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed"
										type="button" data-toggle="collapse"
										data-target="#collapseThree" aria-expanded="false"
										aria-controls="collapseThree">Representative data</button>
								</h2>
							</div>
							<div id="collapseThree" class="collapse"
								aria-labelledby="headingThree" data-parent="#accordionExample">
								<div class="card-body">
										<p>
											<c:forEach items="${voterInformation.civicResponse.offices}" var="office">
												<br><b><c:out value="${office.name}" /></b><br>
											<ul>
												<c:forEach items="${office.officialIndices}" var="index">
													<li><c:out value="${voterInformation.civicResponse.officials.get(index).name}" />, <i><c:out value="	${voterInformation.civicResponse.officials.get(index).party}" /></i><br></li>
												</c:forEach>
												<c:forEach items="${office.officialIndices}" var="index">
												<c:forEach items="${voterInformation.civicResponse.officials.get(index).emails}" var="email">
													<c:out value="	${email}" />
												</c:forEach>
												</c:forEach>
											</ul>
											</c:forEach>
										</p>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingFour">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed"
										type="button" data-toggle="collapse"
										data-target="#collapseFour" aria-expanded="false"
										aria-controls="collapseFour">Voter Registration
										Information</button>
								</h2>
							</div>
							<div id="collapseFour" class="collapse"
								aria-labelledby="headingFour" data-parent="#accordionExample">
								<div class="card-body">
									<div>
										<c:out value="${voterInformation.stateResponse.state.details.voterReg}"
											escapeXml="false" />
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</section>
			</article>
		</main>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

</body>
</html>