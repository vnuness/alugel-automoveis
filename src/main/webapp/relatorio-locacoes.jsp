<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">
        <%@ page contentType="text/html; charset=UTF-8" %>
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
                                        <li class="breadcrumb-item"><a href="#">Locadora</a></li>
                                        <li class="breadcrumb-item active">Relatório Locações</li>
                                    </ol>
                                    <div class="clearfix">

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">

                                        <!-- Resultado da Pesquisa -->
                                        <div class="portlet">
                                            <div class="portlet-heading bg-inverse">
                                                <h3 class="portlet-title">
                                                    <i class="ion-search"></i> RESULTADO DA PESQUISA
                                                </h3>

                                                <div class="portlet-widgets">
                                                    <button id="cadastro_button"
                                                            class="btn btn-outline-success btn-rounded waves-effect waves-light"
                                                            data-toggle="modal"
                                                            data-target="#cadastro">
                                                        <i class="ion-funnel"></i>
                                                        Filtros
                                                    </button>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div id="bg-inverse" class="panel-collapse collapse show">
                                                <div class="portlet-body">
                                                    <div class="table-responsive mt-3">
                                                        <table id="tbl_veiculos" class="table table-bordered" style="width:100%;">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th> Cliente</th>
                                                                    <th> Categoria</th>
                                                                    <th> Veículo</th>
                                                                    <th> Placa</th>
                                                                    <th> Tipo Devolutiva</th>
                                                                    <th> Avaliação</th>
                                                                    <th> Data Locação</th>
                                                                    <th> Data Devolução</th>
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
                                            <h4 class="modal-title" id="CenterModalLabel">Cadastro de Veículos</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group row" >
                                                <label for="inputEmail3" class="col-md-3 col-form-label"> Modelo: <span class="required">*</span></label>

                                                <div class="input-daterange input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="modelo" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="inputEmail3" class="col-md-3 col-form-label"> Montadora: <span class="required">*</span></label>

                                                <div class="input-daterange input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="montadora" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="inputEmail3" class="col-md-3 col-form-label"> Ano: <span class="required">*</span></label>

                                                <div class="input-daterange input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="ano" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row" >
                                                <label for="inputEmail3" class="col-md-3 col-form-label"> Placa: <span class="required">*</span></label>

                                                <div class="input-daterange input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="placa" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="inputEmail3" class="col-md-3 col-form-label"> Renavam: <span class="required">*</span></label>

                                                <div class="input-daterange input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" required="required" name="renavam" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="status" class="col-3 col-form-label">Status: <span class="required">*</span></label>

                                                <div class="col-md-9">
                                                    <select name="status" id="status">
                                                        <option value="">Selecione o Status do Veículo </option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="combustivel" class="col-3 col-form-label">Combustível: <span class="required">*</span></label>

                                                <div class="col-md-9">
                                                    <select name="combustivel" id="combustivel">
                                                        <option value=""> Selecione o tipo de Combustível </option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="cambio" class="col-3 col-form-label">Câmbio: <span class="required">*</span></label>

                                                <div class="col-md-9">
                                                    <select name="cambio" id="cambio">
                                                        <option value=""> Selecione o tipo de Câmbio do Veículo </option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="inputEmail3" class="col-md-3 col-form-label"> Acessórios: <span class="required"></span></label>

                                                <div class="input-daterange input-group col-md-9">
                                                    <textarea  id="acessorios" placeholder="Digite os acessórios do veículo. Ex: Wifi, Entrada USB etc" class="form-control" rows="4" cols="20"></textarea>
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
                        </div>

                    </div>
                    <!-- end container -->
                </div>
                <!-- end content -->

                <footer class="footer">
                    2016 - 2018 Â© Minton <span class="hide-phone">- Coderthemes.com</span>
                </footer>

            </div>
            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <script>
            var resizefunc = [];
        </script>

        <!-- Plugins  -->

    </body>
</html>