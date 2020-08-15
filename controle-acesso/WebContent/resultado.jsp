<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESULTADO</title>
</head>
<body>
	
		<div>
			<!-- Através da EL=Expression Language vamos recuperar os dados da página LOGIN.JSP -->
			<h1>USUARIO</h1>
			<h2>Nome de Usuario : ${param.nome}</h2>
			<h2>Senha : ${param.senha}</h2>
			<p><%=request.getParameter("nome") %></p>
		</div>
		
</body>
</html>