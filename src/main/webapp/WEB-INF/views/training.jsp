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

        <main class="login container">

            <article class="card mx-auto">

                <section class="card-header">

                    	<h1>Training</h1>

                </section>

                <section class="card-body">
                
                <div>
	                <p>Thank you for signing up today to volunteer using VoteAssist!</p>

					<p>We hope we have created an easy to use interface to make your volunteer experience as streamlined as possible. There are however, a few things we’d like to make sure you are aware of.</p>

					<p>You will have the voter’s information and phone number available for you to place your call. After the call finishes you will need to pick one of the following options.</p>
                </div>
                
                <div>
	                <ul>
	                <li>No Answer/Voicemail:<br>
						This option will be used when the voter does not answer their phone. Either the phone goes to voicemail, or rings and rings. This should also be used in cases where someone answers and immediately says they cannot talk at the moment, for whatever reason excluding those listed below. (The next call time will be advanced by a number of hours specified by an administrator)</li>

					<li>Requests Callback: (set date/time)<br>
						This option will be used when the voter cannot speak at the time you called and asks for a call back at a later date or time. You will need to enter the date and time requested in order to schedule the next call. Please be aware that you will probably not be making this next call, so if possible, make some notes in the notes box to help the next volunteer. (The next call time will be scheduled for the date and time entered by you)</li>
	
					<li>Will Vote in Person:<br>
						This option will be used when a voter specifies that they are planning to vote in person at their local polling place and are not interested in voting by mail.  (A reminder call will be scheduled for a time set by an administrator prior to the election date)</li>

					<li>Will Register to Vote by Mail:<br> 
						This option will be used when a voter specifies that they are willing to sign up to vote by mail. You will need to look up the specific information for them in the local voter information tab and help them through the process. (A reminder call will be scheduled for a time set by an administrator prior to their state voter registration deadline.)</li>

					<li>Already Registered to Vote by Mail:<br>
						This option will be used when the voter indicates that they are already registered to vote by mail. (A reminder call will be scheduled for a time set by an administrator prior to the vote by mail deadline)</li>
	
					<li>Is Not Voting:<br>
						This option will be used when the caller states that they plan on not voting in the upcoming election.</li>

					<li>Remove from call list:<br>
						This option will be used when the caller says to be placed on the do not call list/asks to not receive anymore calls.</li>
	                </ul>
                </div>
                
                <div>
                <p>Once you have selected the appropriate option and notes for your call, you will have two options:</p>
                </div>
                
                <div>
	                <ul>
		                <li>SUBMIT/NEXT will save the information you just entered and move on to the next record.</li>
		                <li>SUBMIT/END will save the information you just entered and log you out for the day</li>
	                </ul>
                </div>
                
                <div>
                <p>Please also note that there are two resource tabs that contain information local to the voter you have access to.</p>
                </div>
                
                <div>
	                <ul>
		                <li>The Representative Data drop down will contain names of every elected official from the voter’s area.</li>
		                <li>The Voter Registration Information drop down will provide detailed information for how to register to vote, and how to register to vote by mail in the voter’s area.</li>
	                </ul>
                </div>
                
				<div>By clicking the checkbox you acknowledge the above information and have read it to its fullest.</div>
				
                    <form action="/">
						<input type="checkbox" required/>
						<button class = "btn btn-primary">Confirm</button>
					</form>

                </section>

            </article>

        </main>




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
</body>
</html>