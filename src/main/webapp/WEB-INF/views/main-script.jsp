<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Script</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

</head>
<body>
<div>
<p>1. Hello, may I speak with <b>${voter.name}</b>.</p>
<p>2. This is <b>${username}</b> calling on behalf of <b>${campaignName}</b>.</p>
<p>3. We aren’t concerned if you’re a Democrat or a Republican. What we want to do is make sure that every registered voter goes to the polls and votes. 
A lot of people think that this election is one of the most significant in years. Issues such as National Security, Taxes, and Healthcare will all be affected by this election, and we want every voter in North Carolina to stand up and be counted.</p>
<p>4. Do you plan to go to the polls and vote on <b>${electionMonth} ${electionDate}?</b></p>
<p>YES
5(a). That’s Great! Remember, the deadline to register to vote by mail in <b>${voter.state}</b> is <b>${regCutoffDayOfWeek}, ${regCutoffMonth} ${regCutoffDate}</b>. Do you need information about where your polling place is and what hours it’s open? [If yes to polling place, say:] 
No problem, we can easily look that up for you and get back to you with the information.</p>
<p>UNDECIDED/NO
5(b). Well, we want to remind you that this is a very important election – there’s a lot at stake – and you can voice your opinion by going to the polls and voting.
 In case you decide to vote, would you like information about where your polling place is? [If yes to polling place, say:] No problem, we can easily look that up for you and get back to you with the information.</p>
<p>6. Thanks for your time and think about how great you’ll feel casting your vote, making your voice heard, and being part of this historic election.
Goodbye.</p>
</div>

</body>
</html>