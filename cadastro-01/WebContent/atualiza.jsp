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
<title><f:message key="site.atualiza.titulo"/></title>
</head>
<body>

	<%@ include file="./WEB-INF/snippet/menu/menu-header.jsp" %>

	<section>
		<form action="update" method="POST">
			<input type="hidden" name="txtIdCli" value="${objIdCli}">
			<fieldset>
				<legend><f:message key="site.form.update.legenda"/></legend>
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm"><f:message key="site.form.cadastro.label.nome"/></label>
					<div class="col-sm-8">
						<input type="text" name="txtNm" id="idNm"
							placeholder="<f:message key='site.form.cadastro.placeholder.nome'/>" required="required"
							class="form-control" value="${objCli.nome}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm"><f:message key="site.form.cadastro.label.sobrenome"/></label>
					<div class="col-sm-8">
						<input type="text" name="txtSnm" id="idSnm"
							placeholder="<f:message key='site.form.cadastro.placeholder.sobrenome'/>" required="required"
							class="form-control" value="${objCli.sobrenome}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc"><f:message key="site.form.cadastro.label.data_nasc"/></label>
					<div class="col-sm-8">
						<input type="date" name="txtDtNasc" id="idDtNasc"
							required="required" class="form-control" value='<f:formatDate value="${objCli.dataNasc}" pattern="yyyy-MM-dd"/>'> 
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idGen"><f:message key="site.form.cadastro.label.genero"/></label>
					<div class="col-sm-8">
						<select name="txtGen" id="idGen" required="required" class="form-control">
						<c:choose>
							<c:when test="${objCli.genero eq 'm'.charAt(0)}">
								<option value="0"><f:message key="site.form.cadastro.select.option.sel"/></option>
								<option value="m" selected="selected"><f:message key="site.form.cadastro.select.option.m"/></option>
								<option value="f"><f:message key="site.form.cadastro.select.option.f"/></option>
								<option value="o"><f:message key="site.form.cadastro.select.option.o"/></option>
							</c:when>
								<c:when test="${objCli.genero eq 'f'.charAt(0)}">
								<option value="0"><f:message key="site.form.cadastro.select.option.sel"/></option>
								<option value="m"><f:message key="site.form.cadastro.select.option.m"/></option>
								<option value="f" selected="selected"><f:message key="site.form.cadastro.select.option.f"/></option>
								<option value="o"><f:message key="site.form.cadastro.select.option.o"/></option>
							</c:when>
							<c:otherwise>
								<option value="0"><f:message key="site.form.cadastro.select.option.sel"/></option>
								<option value="m"><f:message key="site.form.cadastro.select.option.m"/></option>
								<option value="f"><f:message key="site.form.cadastro.select.option.f"/></option>
								<option value="o" selected="selected"><f:message key="site.form.cadastro.select.option.o"/></option>
							</c:otherwise>
						</c:choose>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idTel"><f:message key="site.form.cadastro.label.telefone"/></label>
					<div class="col-sm-8">
						<input type="tel" name="txtTel" id="idTel"
							placeholder="(xx) xxxxxx-xxxx" required="required"
							class="form-control" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" value="${objCli.telefone}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-info btn-lg"><f:message key="site.form.update.button.atualizar"/></button>
					</div>
				</div>
			</fieldset>
		</form>
	</section>
	<footer></footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>