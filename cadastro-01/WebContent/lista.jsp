<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">
<title>LISTA</title>
</head>
<body>


	<header>
		<nav></nav>
	</header>
	<div></div>
	<section>
	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt Nasc</th>
				<th>Gênero</th>
				<th>Tel</th>
				<th colspan="2">Editar</th>
			</tr>
						
	<c:forEach var="cli" items="${lista_cli}" varStatus="id">
			<tr>
				<td>${id.count}</td>
				<td>${cli.nome} ${cli.sobrenome}</td>
				<td><f:formatDate value="${cli.dataNasc}" pattern="dd/MM/yyyy"/></td>
				<td>${cli.genero}</td>
				<td>${cli.telefone}</td>
				<td><a href="listar?id_cli=${id.count}">Atualizar</a></td>
				<td><a href="apagar?id_cli=${id.count}">Excluir</a></td>
			</tr>
		
	</c:forEach>			
			
		</table>
		
	</section>
	
	<footer>
		<h2>Info Organizacional &copy;2020</h2>
	</footer>


	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>