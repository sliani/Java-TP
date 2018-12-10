<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<form action="UpdateServlet" method="POST">
			<input name="nom" value="${client.nom}" placeholder="Modifier Nom"/>
			<input name="prenom" value="${client.prenom}" placeholder="Modifier Prenom"/>
			<input type="hidden" name="id" value="${client.id}" placeholder="Modifier Prenom"/>
			<input name="edit" type="submit" value="Editer"/>
		</form>
	</div>
</body>
</html>