<%@page import="br.com.fiap.bean.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<th>G�nero</th>
				<th>Tel</th>
				<th>Editar</th>
			</tr>
						

	<%
			
		List<Cliente> lista = (List<Cliente>)request.getAttribute("listaCli");
		
		int count = 1;
	
		for(Cliente cli : lista){
			out.println("<tr>");
			out.println("<td>"+ count +"</td>");
			out.println("<td>"+ cli.getNome() +" "+ cli.getSobrenome() +"</td>");
			out.println("<td>"+ cli.getDataNasc() +"</td>");
			
			if(cli.getGenero() == 'm'){
				out.println("<td>Masculino</td>");
			}else if(cli.getGenero() == 'f'){
				out.println("<td>Feminino</td>");
			}else if(cli.getGenero() == 'o'){
				out.println("<td>Outros</td>");
			}
			
			out.println("<td>"+ cli.getTelefone() +"</td>");
			out.println("<td><a href=listar?id-cli="+ count +">Editar</a></td>");
			out.println("</tr>");
			count++;
		}
		
	%>
			
		</table>
		
	</section>
	<footer></footer>


	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>