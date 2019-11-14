<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Exibir Represa</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
            <script type="text/javascript" src="js/functions.js"></script>
        </head>

        <body>
        		
        		 <!-- Modal Volume Armazenado -->
                <div class="modal fade" id="volume-armazenado-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Registrar Volume Armazenado</h4>
                            </div>
                            <div class="modal-body">
                            	<form action="registrarVolArmazenado" method="post">
                            		<div class="form-group row">
	                                <label for="validationDefault02">Digite o Volume Armazenado:</label>
	                                <input type="number" class="form-control"
									name="volumeArmazenado"
									aria-describedby="inputGroupPrepend2" required max="999" maxlength="3" oninput="maxLengthCheck(this)">
									</div>
									<div class="form-group row">
	                                    <input type="hidden" name="id" value="${represa.id }" />
	                                    <button type="submit" class="btn btn-primary">Registrar</button>
	                                </div>    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
        		
        		 <!-- Modal pluviometria -->
                <div class="modal fade" id="pluviometria-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Registrar Pluviometria</h4>
                            </div>
                            <div class="modal-body">
                                <form action="registrarPluviometria" method="post">
                            		<div class="form-group row">
	                                <label for="validationDefault02">Digite a Pluviometria:</label>
	                                <input type="number" class="form-control" name="pluviometria" aria-describedby="inputGroupPrepend2" 
	                                required max="999" maxlength="3" oninput="maxLengthCheck(this)">
									</div>
									<div class="form-group row">
	                                    <input type="hidden" name="id" value="${represa.id}" />
	                                    <button type="submit" class="btn btn-primary">Registrar</button>
	                                </div>    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
        		
                <!-- Barra superior com os menus de navegação -->
				<c:import url="../Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Exibir Represa #${represa.id }</h3>
                    <div class="row">
                    <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${represa.nomeRepresa}
                            </p>
                        </div>
                        <div class="col-md-2">
                            <p><strong>Indice 1:</strong></p>
                            <p>
                            	<c:if test="${not empty indice1}"> 
                            		<fmt:formatNumber type="number" maxFractionDigits="2" value="${indice1}"/> 
                            	</c:if>
                            	<c:if test="${empty indice1}">Vazio</c:if>
                            </p>
                        </div>
                        <div class="col-md-2">
                            <p><strong>Indice 2:</strong></p>
                            <p>
                            	<c:if test="${not empty indice2}"> 
                            		<fmt:formatNumber type="number" maxFractionDigits="2" value="${indice2}"/> 
                            	</c:if>
                            	<c:if test="${empty indice2}"> Vazio </c:if>
                            </p>
                        </div>
                        <div class="col-md-2">
                            <p><strong>Indice 3:</strong></p>
                            <p>
                            	<c:if test="${not empty indice3}"> 
                            		<fmt:formatNumber type="number" maxFractionDigits="2" value="${indice3}"/>
                            	</c:if>
                            	<c:if test="${empty indice3}"> Vazio </c:if>
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <p><strong>Volume Util</strong>
                            </p>
                            <p>
                                ${represa.volumeUtil}
                            </p>
                        </div>
                        <div class="col-md-4">
                            <p><strong>Volume Reserva Tecnica</strong>
                            </p>
                            <p>
                                ${represa.volumeReservaTecnica}
                            </p>
                        </div>
                    </div>
                    </div>
                    </div>
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="alterar_local?id=${represa.id }" class="btn btn-primary" data-toggle="modal" data-target="#volume-armazenado-modal">Registrar Volume Armazenado</a>
                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#pluviometria-modal">Registrar Pluviometria</a>
                            <a href="ListarRepresasExibir?id=${represa.sisAbs.id }" class="btn btn-default">Voltar</a>
                        </div>
                    </div> 
                    <hr />
                    <h3>Historico de Volume Armazenado</h3>
                    <c:if test="${not empty volArmazenado}">
			            <div class="table-responsive col-md-12">
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th>Id</th>
			                            <th>Volume Armazeando</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <c:forEach var="vas" items="${volArmazenado}">
				                            <tr>
				                                <td>${vas.id_volumeArmazenado} </td>
				                                <td>${vas.volumeArmazenado} milhões de m³</td>
				                            </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
			            </div>
        			</c:if>
			        <c:if test="${empty volArmazenado}">
			            <div class="alert alert-info" role="alert">N&atilde;o h&aacute; volume armazenado nesta represa.</div>
			        </c:if>
			        <hr />
                    <h3>Historico de Pluviometria</h3>
                    <c:if test="${not empty pluviometriaList}">
			            <div class="table-responsive col-md-12">
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th>Id</th>
			                            <th>Pluviometria</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <c:forEach var="pl" items="${pluviometriaList}">
				                            <tr>
				                                <td>${pl.id_pluviometria}</td>
				                                <td>${pl.pluviometria} ml</td>
				                            </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
			            </div>
        			</c:if>
			        <c:if test="${empty pluviometriaList}">
			            <div class="alert alert-info" role="alert">N&atilde;o h&aacute; pluviometria nesta represa.</div>
			        </c:if>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>