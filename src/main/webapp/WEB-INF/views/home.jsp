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
			<button>Change "Current" Date</button>
		</form>
		
		<label>"Current" Date: ${timeMachineString}</label>
		
		<ul class="nav">
			
			<li class="nav-item">
			<a class="nav-link" href="/logout">Logout</a>
			</li>
		</ul>
	</nav>
	<div class="top left">
		<main class="container">

			<article class="card mx-auto">

				<section class="card-header">
					<h1>Voter Information</h1>
				</section>

				<section class="card-body">

					Name - ${voter.name}<br> Phone - ${voter.phone}<br>
					Street Address - ${voter.address}<br> City - ${voter.city}<br>
					State - ${voter.state}<br> Zip Code - ${voter.zip}<br>
					Party Preference - ${voter.partyPref}<br> Is this person
					voting by mail? - ${voter.voteByMail}<br> Next Scheduled Call
					- ${nextCall}<br> Last Call - ${lastCall}<br>

				</section>

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
			<textarea class="note-text" rows="3" name="notes">${voter.notes}</textarea>
		</div>
		<div>
			<input type = "hidden"name = "voterId" value = "${voter.id}">

			<input type="radio" id="NA" name="result" value="NA" required>
			<label for="NA">No answer/Voicemail</label><br> 
			<input type="radio" id="RQ" name="result" value="RQ"> 
			<label for="RQ">Requested callback</label>
			<input type="datetime-local" name="nextCall"><br> 
			<input type="radio" id="VIP" name="result" value="VIP"> 
			<label for="VIP">Will vote in person</label><br> 
			<input type="radio" id="WVBM" name="result" value="WVBM"> 
			<label for="WVBM">Will register to Vote by Mail</label><br>
			<input type="radio" id="AVBM" name="result" value="AVBM">
			<label for="AVBM">Already registered to Vote by Mail</label><br> 
			<input type="radio" id="NV" name="result" value="NV"> 
			<label for="NV">Not voting</label><br> 
			<input type="radio" id="DNC" name="result" value="DNC"> 
			<label for="DNC">Do not call</label><br>
		</div>
		<div>
			<button name="button" value="next" onClick="mySavedNoteAlert()">Submit/Next</button>
			<button name="button" value="end">Submit/END</button>
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

                    <h1>Script</h1>

                </section>

                <section class="card-body">

					<jsp:include page="main-script.jsp"/>

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
							<div class="card-header" id="headingOne">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed"
										type="button" data-toggle="collapse"
										data-target="#collapseOne" aria-expanded="false"
										aria-controls="collapseOne">Representative data</button>
								</h2>
							</div>
							<div id="collapseOne" class="collapse"
								aria-labelledby="headingOne" data-parent="#accordionExample">
								<div class="card-body">
										<p>
											<c:forEach items="${civicResponse.offices}" var="office">
												<br><b><c:out value="${office.name}" /></b><br>
											<ul>
												<c:forEach items="${office.officialIndices}" var="index">
													<li><c:out value="${civicResponse.officials.get(index).name}" />, <i><c:out value="	${civicResponse.officials.get(index).party}" /></i><br></li>
												</c:forEach>
												<c:forEach items="${office.officialIndices}" var="index">
												<c:forEach items="${civicResponse.officials.get(index).emails}" var="email">
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
							<div class="card-header" id="headingTwo">
								<h2 class="mb-0">
									<button class="btn btn-link btn-block text-left collapsed"
										type="button" data-toggle="collapse"
										data-target="#collapseTwo" aria-expanded="false"
										aria-controls="collapseTwo">Voter Registration
										Information</button>
								</h2>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-parent="#accordionExample">
								<div class="card-body">
									<div>
										<c:out value="${stateResponse.state.details.voterReg}"
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
	<script>
		function mySavedNoteAlert() {
			alert("Notes saved successfully!");
		}
	</script>
</body>
</html>