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

<script type="text/javascript" src="js/functions.js"></script>
<script defer src="js/bootstrap.min.js"></script>


<title>Atualizar Represa</title>
</head>
<body>

	<div class="pai">
		<c:import url="../Menu.jsp"/>
		<div class="container">
			<form action="atualizarRepresa" method="post" id="cadastro">
				<h1>Atualizar Represa</h1>
				<hr>
				<div class="form-group row">
					<div class="col-md-1">
						<label for="validationDefault01">Id</label> 
						<input type="text" class="form-control" name="id" value="${represa.id }" id="validationDefault01" readonly>
						
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-3">
						<label for="validationDefault01">Nome</label> 
						<input type="text" class="form-control" name="nomeRepresa" value="${represa.nomeRepresa }" id="validationDefault01" required>
						
					</div>
					<div class="col-md-3">
						<label for="fila">Escolha o Sistema de Abastecimento:</label>
                    	<select class="form-control" name="sisAbs.id">
                    		<option value="${represa.sisAbs.id}" selected="selected" hidden>${represa.sisAbs.nome}</option>
	                        <c:forEach var="abs" items="${SisAbs}">
	                            <option value="${abs.id}">${abs.nome}</option>
	                        </c:forEach>
                    	</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-3">
						<label for="validationDefaultUsername">Volume Util</label>
						<div class="input-group">
							<input type="number" class="form-control"
								name="volumeUtil"
								aria-describedby="inputGroupPrepend2" value="${represa.volumeUtil }" 
								required max="999" maxlength="3" oninput="maxLengthCheck(this)">
						</div>
					</div>
					<div class="col-md-3">
						<label for="validationDefault02">Volume Reserva Tecnica</label>
						<input type="number" class="form-control"
								name="volumeReservaTecnica"
								aria-describedby="inputGroupPrepend2" value="${represa.volumeReservaTecnica }" 
								required max="999" maxlength="3" oninput="maxLengthCheck(this)" >
					</div>
				</div>
						<button class="btn btn-success" type="submit">Atualizar</button> 
					
			</form>
		</div>
	</div>
</body>
</html>