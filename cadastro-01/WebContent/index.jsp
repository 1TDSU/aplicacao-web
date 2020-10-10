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
<title><f:message key="site.titulo"/></title>
</head>
<body>

	<header>
		<nav>
			<ul class="nav">
				<li class="nav-link"><a href="index.jsp"><f:message key="site.menu.header.inicio"/></a></li>
				<li class="nav-link"><a href="listaall"><f:message key="site.menu.header.clientes"/></a></li>
   			</ul>
		</nav>
	</header>
	<div>
		<h2>${param.msgStatus}</h2>
	</div>
	<section>
		<form action="cliente" method="POST">
			<fieldset>
				<legend><f:message key="site.form.cadastro.legenda"/></legend>
				
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm"><f:message key="site.form.cadastro.label.nome"/></label>
					<div class="col-sm-8">
						<input type="text" name="txtNm" id="idNm"
							placeholder="Digite seu nome" required="required"
							class="form-control" value="">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm"><f:message key="site.form.cadastro.label.sobrenome"/></label>
					<div class="col-sm-8">
						<input type="text" name="txtSnm" id="idSnm"
							placeholder="Digite seu sobrenome" required="required"
							class="form-control" value="">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc"><f:message key="site.form.cadastro.label.data_nasc"/></label>
					<div class="col-sm-8">
						<input type="date" name="txtDtNasc" id="idDtNasc"
							required="required" class="form-control" value="">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idGen"><f:message key="site.form.cadastro.label.genero"/></label>
					<div class="col-sm-8">
						<select name="txtGen" id="idGen" required="required" class="form-control">
							<option value="0" selected="selected"><f:message key="site.form.cadastro.select.option.sel"/></option>
							<option value="m"><f:message key="site.form.cadastro.select.option.m"/></option>
							<option value="f"><f:message key="site.form.cadastro.select.option.f"/></option>
							<option value="o"><f:message key="site.form.cadastro.select.option.o"/></option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idTel"><f:message key="site.form.cadastro.label.telefone"/></label>
					<div class="col-sm-8">
						<input type="tel" name="txtTel" id="idTel"
							placeholder="(xx) xxxxxx-xxxx" required="required"
							class="form-control" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" value="">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success btn-lg"><f:message key="site.form.cadastro.button.enviar"/></button>
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