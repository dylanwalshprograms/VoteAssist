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


		<main class="container">
			
        	<article class="card mx-auto">

            	<section class="card-header">

                	<h1>Script Editor</h1>

                </section>
				<form method="post" action="/script-submit">
                <section class="card-body">
                <div id="editor"><textarea name="scriptText" value="${script.scriptText}" rows="50" cols="50">${script.scriptText}</textarea></div>
                </section>
				<input type="hidden" name="scriptName" value="${script.scriptName}" />
			    <input type="submit" value="Submit Changes" class="link" />
			</form>
            </article>
            
			    
        	</main>


<script>
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .catch( error => {
            console.error( error );
        } );
</script>
</body>
</html>