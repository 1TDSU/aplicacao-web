<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TURMAS</title>
</head>
<body>
	
	<div>
		<a href="exemplo">LOAD-SELECT</a>
	</div>
	
	<div>
		<form action="">
			<fieldset>
				<legend>MATRICULAS</legend>
				<div>
					<label>Nome</label><br>
					<input type="text" name="txtNm">
				</div>
				<div>
					<select name="turma-sel">
						
						<c:forEach var="opt" items="${turmas}">
							<option value="${opt}">${opt}</option>
						</c:forEach>
						
					</select>
					
					<div>
						
					</div>
					
					
				</div>
				<div>
					<button type="submit">ENVIAR</button>
				</div>
			</fieldset>
		</form>
	</div>
	
	
	
</body>
</html>