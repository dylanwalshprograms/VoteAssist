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
	<div class="top left">
		<main class="container">

        	<article class="card mx-auto">

            	<section class="card-header">

                	<h1>Campaign Configuration</h1>

                </section>

                <section class="card-body">

					<form action="/admin/update-config">
					
						<label>Campaign Name:</label>
						<input type="text" name="campaignName"><br>
						
						<label>No Answer delay:</label>
						<input type="number" name="delayNA" min="0">
						<label>MIN HOURS before next call scheduled.</label><br>
						
						<label>Already VBM delay:</label>
						<input type="number" name="delayAVBM" min="0">
						<label>MIN DAYS before election day.</label><br>
						
						<label>Will vote in person delay:</label>
						<input type="number" name="delayVIP" min="0">
						<label>MIN DAYS before election day.</label><br>
						
						<label>Will VBM delay:</label>
						<input type="number" name="delayWVBM" min="0">
						<label>MIN DAYS before VBM registration deadline.</label><br>
						
						<label>Not Voting delay:</label>
						<input type="number" name="delayNV" min="0">
						<label>MIN HOURS before next call scheduled.</label><br>
						
						<label>Set Response Priority:</label><br>
						
						<input type="radio" id="prioritizeWVBM" name="priority" value="prioritizeWVBM">
						<label for="prioritizeWVBM">Prioritize WVBM reminders</label><br>
						 
						<input type="radio" id="prioritizeWVIP" name="priority" value="prioritizeWVIP"> 
						<label for="prioritizeWVIP">Prioritize WVIP reminders</label><br> 
						
						<input type="radio" id="prioritizeSTD" name="priority" value="prioritizeSTD"> 
						<label for="prioritizeSTD">Standard Priority</label><br>
						
						<button>UPDATE CAMPAIGN</button>
					
					
					</form>

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