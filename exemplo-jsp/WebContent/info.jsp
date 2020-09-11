<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="imports.jsp"%>
<title>INFO-IMG</title>
</head>
<body>

	<div>
		<figure>
			<img alt="" src="${param.imgUrl}">
		</figure>
	</div>
	<div>
		<a href="index.jsp">INÍCIO</a>
	</div>
	
<%@ include file="rodape.jsp"%>
</body>
</html>