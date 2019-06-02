<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <title>Locadora de Automóveis</title>

        <jsp:include page="imports.jsp"/>

    </head>

    <body class="fixed-left">

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            <jsp:include page="navbar.jsp" />
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->

            <jsp:include page="left-menu.jsp"/>

            <!-- Left Sidebar End -->




            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->                      
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <!-- Page-Title -->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="page-title-box">
                                    <h4 class="page-title">Bem-Vindo !</h4>
                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">Minton</a></li>
                                        <li class="breadcrumb-item active">Dashboard</li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">

                                        <!-- Resultado da Pesquisa -->
                                        <div class="portlet">
                                            <div class="portlet-heading bg-inverse">
                                                <h3 class="portlet-title">
                                                    <i class="ti-user"></i> Usuários
                                                </h3>

                                                <div class="portlet-widgets">
                                                    <button id="cadastro_button"
                                                            class="btn btn-outline-success btn-rounded waves-effect waves-light"
                                                            data-toggle="modal"
                                                            data-target="#cadastro">
                                                        <i class="ti-plus"></i>
                                                        Cadastrar Usuário
                                                    </button>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div id="bg-inverse" class="panel-collapse collapse show">
                                                <div class="portlet-body">
                                                    <div class="table-responsive mt-3">
                                                        <table id="tbl_usuarios" class="table table-bordered" style="width:100%;">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th> Matrícula</th>
                                                                    <th> Email</th>
                                                                    <th> Nome</th>
                                                                    <th> Cargo</th>
                                                                    <th> Filial</th>
                                                                    <th> Data Cadastro</th>
                                                                    <th> Ações</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div> <!-- end row -->

                                </div>
                            </div>
                        </div>

                        <div id="cadastro" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="CenterModalLabel"
                             aria-hidden="true">
                            <form class="form-horizontal" id="cad-veiculos" role="form" action="" type="POST">
                                <input type="hidden" name="id" value=""/>

                                <div class="modal-dialog modal-dialog-centered modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="CenterModalLabel">Cadastro de Usuários</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group row" id="row-matricula" >
                                                <label for="matricula" class="col-md-3 col-form-label"> Matrícula: <span class="required">*</span></label>

                                                <div class="input-group col-md-9">
                                                    <input class="form-control" name="matricula" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row" id="row-nome">
                                                <label for="nome" class="col-md-3 col-form-label"> Nome: <span class="required">*</span></label>

                                                <div class="input-group col-md-9">
                                                    <input class="form-control" name="nome" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row" id="row-email">
                                                <label for="email" class="col-md-3 col-form-label"> Email: <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control" name="email" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row" id="row-senha">
                                                <label for="senha" class="col-3 col-form-label">Senha: <span class="required">*</span></label>

                                                <div class="col-md-9">
                                                    <input class="form-control" name="senha" required="required" type="password" autocomplete="off">
                                                </div>
                                            </div>


                                            <div class="form-group row" id="row-filial">
                                                <label for="filial" class="col-3 col-form-label">Filial: <span class="required">*</span></label>

                                                <div class="col-md-9">
                                                    <select name="filial" id="filial">
                                                        <option value="">Selecione a Filial do Funcionário </option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group row" id="row-cargo">
                                                <label for="cargo" class="col-3 col-form-label">Cargo: <span class="required">*</span></label>

                                                <div class="col-md-9">
                                                    <select name="cargo" id="cargo">
                                                        <option value=""> Selecione o Cargo do Funcionário </option>
                                                    </select>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="cancelar" class="btn btn-secondary waves-effect" data-dismiss="modal">Cancelar
                                            </button>
                                            <button type="submit" id="enviar" class="btn btn-success waves-effect waves-light">
                                                Enviar
                                            </button>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </form>
                        </div><!-- /.modal -->

                    </div>
                    <!-- end container -->
                </div>
                <!-- end content -->

                <jsp:include page="footer.jsp"/>

            </div>

        </div>
        <!-- END wrapper -->



        <script>
            var resizefunc = [];</script>

        <script src="../scripts/usuarios-script.js"></script>

        <!-- Plugins  -->

    </body>
</html>