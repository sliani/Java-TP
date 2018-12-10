<%@ page import="java.util.*"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ib.formation.dao.Client" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	 List<Client> l = (List<Client>)request.getAttribute("listeClient");
	 if (l == null) { l = new ArrayList<Client>();} 
	 
	 String message = request.getParameter("message");
	 request.setAttribute("message", message);
	%>
	<p>
	${message}
	</p>
	<h3> Bienvenue ${sessionScope.login}</h3>
	<div>
	<h1>Liste des Clients</h1>
	<a href="./ajouterClient.jsp">ajouter</a>
	<form class="example" action="SearchServlet" style="margin:auto;max-width:300px" method="GET" name="nom">
	 <input type="text" placeholder="Rechercher.." name="rechercher">
	 <button type="submit"><i class="fa fa-search"></i></button>
	</form>
		<table>
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Editer</th>
					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody>
			<% for (Client c : l) { %>
				<tr>
					<td> <% out.print(c.getNom()); %></td>
					<td> <%=c.getPrenom() %></td>
					<td><a href="UpdateServlet?id=<%= c.getId() %>">editer</a></td>
					<td><a href="DeleteServlet?id=<%= c.getId() %>">supprimer</a></td>
				</tr>
			<% } %>
			</tbody>
		</table>
		
		<form action="LogoutServlet" method="GET">
			<input name="disconnect" type="submit" value="Disconnect"/>
		</form>
		
	</div>
</body>
</html>