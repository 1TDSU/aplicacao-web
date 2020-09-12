<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="imports.jsp"%>
<title>INFO-IMG</title>
</head>
<body>

	<div>
		<c:choose>
			<c:when test="${param.imgUrl != ''}">
				<figure>
					<img alt="" src="${param.imgUrl}">
				</figure>
			</c:when>
			<c:when test="${param.imgUrl == ''}">
				
				<jsp:forward page="no-img.html"/>
								
			</c:when>
		</c:choose>
	</div>
	<div>
		<a href="index.jsp">INÍCIO</a>
	</div>


	<%@ include file="rodape.jsp"%>
</body>
</html>