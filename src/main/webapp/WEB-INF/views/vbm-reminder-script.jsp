<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VBM Reminder</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

	<div>
		<p>
			1. Hello, may I speak with <b>${voterinformation.voterData.name}</b>.
		</p>
		<p>
			2. This is <b>${voterinformation.currentVolunteer.name}</b> calling on behalf of <b>${voterinformation.campaignName}</b>.
		</p>
		<p>
			3. We last reached out on <b>${voterinformation.lastCall}</b> and you indicated that you
			would be registering to vote by mail.  Have you had a chance to register
			to vote by mail?
		</p>
		<p>
			YES 4(a) That's great, remember to mail in your ballot by the date
			indicated on the form.  Is there any other information I can give you
			today?
		</p>
		<p>
			NO 4(b) No problem, this call was actually scheduled to remind you that
			you still have until <b>${voterinformation.regCutOffDay}</b> to register to vote by mail.
			Do you have any specific question I can answer to assist you in getting
			registered to vote by mail?		
		</p>
		<p>
			5. Thanks for your time and think about how great you’ll feel
			casting your vote, making your voice heard, and being part of this
			historic election. Goodbye.
		</p>
	</div>

</body>
</html>