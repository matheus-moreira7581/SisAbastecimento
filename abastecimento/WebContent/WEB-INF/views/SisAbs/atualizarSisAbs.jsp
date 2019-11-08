<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Darker+Grotesque:300,400,500,600,700,800,900$display=swap">


<!-- css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">

<!-- js -->

<script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

<script defer src="js/bootstrap.min.js"></script>


<title>Home</title>
</head>
<body>

	<div class="pai">
		<c:import url="../Menu.jsp"/>
		<div class="container">
			<form action="atualizarSisAbs" method="post" id="cadastro">
				<h1>Cadastro de Sistema de Abastecimento</h1>
				<hr>
				<div class="form-group">
					<div class="col-md-12 mb-6">
						<label for="validationDefault01">Id</label> 
						<input type="text" class="form-control" name="id" value="${sAbs.id}" id="validationDefault01" readonly>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-6 mb-3">
						<label for="validationDefault01">Nome</label> <input type="text"
							class="form-control" name="nome" value="${sAbs.nome }" id="validationDefault01"
							required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="validationDefaultUsername">Estado</label>
						<div class="input-group">
							<input type="text" class="form-control"
								id="validationDefaultUsername" name="estado" value="${sAbs.estado }"
								aria-describedby="inputGroupPrepend2" required>
						</div>
					</div>

				</div>
				<div class="form-group">
					<div class="col-md-6 mb-3">
						<label for="validationDefault02">Municipios</label>
						<textarea class="form-control" name="municipio"
							id="validationDefault02" required>${sAbs.municipio}</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12 mb-3">
						<button class="btn btn-success" type="submit" >Atualizar</button> 
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>