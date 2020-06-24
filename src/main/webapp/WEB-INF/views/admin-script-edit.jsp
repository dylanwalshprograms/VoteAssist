<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
<script src="https://cdn.ckeditor.com/ckeditor5/19.1.1/classic/ckeditor.js"></script>
</head>
<body>

<nav class="navbar bg-light">
				
		<img width = "5%" alt="vote-assist-logo" src="VoteAssistLogo.png" class="img-icon">
		
				<div>	
			
					
				
					<a type="button" class="btn btn-primary" href="/admin">Return to Admin Dashboard</a>
					
					<a type="button" class="btn btn-danger" href="/logout">Logout</a>
				
				</div>
		
		
		
	</nav>


		<main class="container">
			
        	<article class="card mx-auto">

            	<section class="card-header">

                	<h1>Script Editor</h1>

                </section>
				
                <section class="card-body">
                <form action="/script-submit" method="post">
               		 
               		 	<textarea id="editor" name="scriptText" rows="50" cols="50">${script.scriptText}</textarea>
               		
               		 	<input type="hidden" name="scriptName" value="${script.scriptName}" />
			    		<button class="btn btn-info">Submit</button>
				</form>
                </section>
				
            </article>
            
			    
        	</main>


<script>
    const editor = ClassicEditor.create(document.querySelector('#editor'));
</script>
</body>
</html>