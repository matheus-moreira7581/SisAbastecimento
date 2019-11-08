<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar Represas</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Represa(s) do Sistema de abastecimento ${sisAbs.nome}</h3>
        <c:if test="${not empty represas}">
            <div class="table-responsive col-md-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Volume Util</th>
                            <th>Volume Reserva Tecnica</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="rs" items="${represas}">
                        	<form action="exibirRepresa" method="get">
	                            <tr>
	                                <td>${rs.nomeRepresa}</td>
	                                <td>${rs.volumeUtil}</td>
	                                <td>${rs.volumeReservaTecnica}</td>
	                                <td>
	                                  <button name="id" value="${rs.id}" class="btn btn-warning">Exibir</button>
									  <button name="id" formaction="atualizarRepresaExibir" value="${rs.id}" class="btn btn-success">Atualizar</button>
									  <button name="id" formaction="excluirRepresa" value="${rs.id}" class="btn btn-danger">Excluir</button>			                         
			                      </td>
	                            </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <c:if test="${empty represas}">
            <div class="alert alert-info" role="alert">N&atilde;o h&aacute; represas neste sistema de abastecimento.</div>
        </c:if>
        <a href="listarAbastecimentoExibir" class="btn btn-default">Voltar</a>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>