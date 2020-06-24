<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIP Reminder</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

	<div>
		<p>
			1. Hello, may I speak with <b>${voterInformation.voterData.name}</b>.
		</p>
		<p>
			2. This is <b>${voterInformation.currentVolunteer.name}</b> calling on behalf of <b>${voterInformation.campaignName}</b>.
		</p>
		<p>
			3. We last reached out on <b>${voterInformation.getLastCallInWords}</b> and you indicated that you
			would be voting in person.  Are you still planning to vote on <b>${voterInformation.getElectionDateInWords()}</b>?
		</p>
		<p>
			4. Thanks for your time and think about how great you’ll feel
			casting your vote, making your voice heard, and being part of this
			historic election. Goodbye.
		</p>
	</div>

</body>
</html>