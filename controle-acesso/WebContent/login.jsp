<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/bootstrap.css" type="text/css">

<title>LOGIN</title>
</head>
<body>
 
	

	<!-- Carregador do Modal -->
	<button type="button" class="btn btn-info" data-toggle="modal"
		data-target="#box-login">LOGIN</button>

	<div class="modal fade" role="dialog" id="box-login">
		<div class="modal-dialog modal-lg">

			<!-- CONTEÚDO -->
			<div class="modal-content">
				<div class="modal-header">
					<h4>Login de Usuários</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">

							
					<form class="form-horizontal" action="index.aspx" method="post">
						<div class="form-group">
							<label class="control-label col-sm-2" for="usuario">Nome
								de Usuário</label>
							<div class="col-sm-10">
								<input type="text" name="nome" id="usuario"
									placeholder="Digite seu nome de usuário." required="required"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="senha">Senha</label>
							<div class="col-sm-10">
								<input type="password" name="senha" id="senha"
									placeholder="Digite sua senha." required="required"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Enviar</button>
						</div>
					</form>
					
					

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
				</div>
			</div>

		</div>
	</div>

	<div>
		<p><a href="validador">VALIDADOR</a></p>
	</div>
	
	<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>