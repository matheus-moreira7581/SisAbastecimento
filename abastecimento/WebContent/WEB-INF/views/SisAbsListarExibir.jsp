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
    <title>Lista SisAbs</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
         <div class="row col-md-10">
	         <h3 class="col-md-8">Exibir Sistema de Abastecimento #${sAbs.id }</h3>
	         <a href="novoSisAbs" class="btn btn-warning">Novo SisAbs</a>
         </div>
        <c:if test="${not empty SisAbs}">
            <div class="table-responsive col-md-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Estado</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sa" items="${SisAbs}">
                        	<form action="exibirSisAbs" method="get">
	                            <tr>
	                                <td>${sa.nome}</td>
	                                <td>${sa.estado}</td>
	                                <td>
	                                  <button name="id" value="${sa.id}" class="btn btn-warning">Exibir</button>
									  <button name="id" formaction="atualizarSisAbsExibir" value="${sa.id}" class="btn btn-success">Atualizar</button>
									  <button name="id" formaction="excluirSisAbs" value="${sa.id}" class="btn btn-danger">Excluir</button>			                         
			                      </td>
	                            </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <c:if test="${empty SisAbs}">
            <div class="alert alert-info" role="alert">N&atilde;o h&aacute; sistema de abastecimento registrado.</div>
        </c:if>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>