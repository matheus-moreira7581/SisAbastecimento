<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Exibir Sistema de Abastecimento</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="../Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Exibir Sistema de Abastecimento #${sAbs.id }</h3>
                    <div class="row">
                    <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-8">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${sAbs.nome}
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <p><strong>Estado</strong>
                            </p>
                            <p>
                                ${sAbs.estado}
                            </p>
                        </div>
                        <div class="col-md-4">
                            <p><strong>Municipios</strong>
                            </p>
                            <p>
                                ${sAbs.municipio}
                            </p>
                        </div>
                    </div>
                    </div>
                    </div>
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="alterar_local?id=${sAbs.id }" class="btn btn-primary">Alterar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="ListarRepresasExibir" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>