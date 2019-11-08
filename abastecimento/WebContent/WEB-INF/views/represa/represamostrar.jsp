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
                            	<form action="remover_local" method="post">
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
                                <form action="remover_local" method="post">
                            		<div class="form-group row">
	                                <label for="validationDefault02">Digite a Pluviometria:</label>
	                                <input type="number" class="form-control"
									name="pluviometria"
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
        		
                <!-- Barra superior com os menus de navegação -->
				<c:import url="../Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Exibir Represa #${represa.id }</h3>
                    <div class="row">
                    <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-8">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${represa.nomeRepresa}
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
                    <hr />
                    <h3>Historico de Pluviometria</h3>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>