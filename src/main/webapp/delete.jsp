<%@page import="it.gestionetv.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
		<body>
			<p> televisore da eliminare : </p>
			<%Televisore televisoreInPagina = (Televisore)request.getAttribute("televisoreDaInviareAPaginaRimozione"); %>
			<p>marca <%= televisoreInPagina.getMarca() %> </p>
			<p>modello <%= televisoreInPagina.getModello() %> </p>
			<p>prezzo <%= televisoreInPagina.getPrezzo() %> </p>
			<p>numero pollici <%= televisoreInPagina.getNumeroPollici() %> </p>
			<p>codice <%= televisoreInPagina.getCodice() %> </p>
			<br>
			<br>
			<br>
			<form action="ExecuteDeleteTelevisoreServlet" method="post">
			<input type ="hidden" name="idDaRimuovere" value="<%= televisoreInPagina.getIdTelevisore() %>">
			<input type="submit" value="elimina">
			</form>
		</body>
</html>