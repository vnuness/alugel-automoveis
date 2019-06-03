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
            <!-- navbar -->
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
                                        <li class="breadcrumb-item active">Cadastro Clientes</li>
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
                                                    <i class="ti-user"></i> CLIENTES
                                                </h3>

                                                <div class="portlet-widgets">
                                                    <button id="cadastro_button"
                                                            class="btn btn-outline-success btn-rounded waves-effect waves-light"
                                                            data-toggle="modal"
                                                            data-target="#cadastro">
                                                        <i class="ti-plus"></i>
                                                        Adicionar Cliente
                                                    </button>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div id="bg-inverse" class="panel-collapse collapse show">
                                                <div class="portlet-body">
                                                    <div class="table-responsive mt-3">
                                                        <table id="tbl_clientes" class="table table-bordered" style="width:100%;">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th> Cliente</th>
                                                                    <th> Tipo</th>
                                                                    <th> CPF/CNPJ</th>
                                                                    <th> E-mail</th>
                                                                    <th> Status</th>
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

                        <!-- MODAL -->
                        <div id="cadastro" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="CenterModalLabel"
                             aria-hidden="true">
                            <form class="form-horizontal" id="cad-cliente" role="form">
                                <input type="hidden" name="id" value=""/>

                                <div class="modal-dialog modal-dialog-centered modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="CenterModalLabel">Cadastro de Cliente</h4>
                                        </div>
                                        <div class="modal-body">

                                            <div class="row" >
                                                <label class="col-md-3 col-form-label"> Tipo de pessoa: <span class="required">*</span></label>

                                                <div class="col-md-3 form-group row col-form-label">
                                                        <div class="radio radio-primary">
                                                            <input name="categoria_cliente" id="radio-pessoa-fisica" checked="checked" value="1" type="radio">
                                                            <label for="radio-pessoa-fisica">
                                                                Pessoa Física
                                                            </label>
                                                        </div>

                                                </div>
                                                <div class="col-md-3 form-group row col-form-label">
                                                        <div class="radio radio-primary">
                                                            <input name="categoria_cliente" id="radio-pessoa-juridica" value="2" type="radio">
                                                            <label for="radio-pessoa-juridica">
                                                                Pessoa Jurídica
                                                            </label>
                                                        </div>

                                                </div>
                                                <div class="col-md-3 form-group row col-form-label">
                                                        <div class="radio radio-primary">
                                                            <input name="categoria_cliente" id="radio-motorista-app" value="3" type="radio">
                                                            <label for="radio-motorista-app">
                                                                Motorista de Aplicativo
                                                            </label>
                                                        </div>

                                                </div>
                                            </div>

                                            <hr>

                                            <!-- Form de pessoa fisica -->
                                            <div id="cadastro-pessoa-fisica">

                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label class="col-form-label">Nome Completo</label>
                                                        <input type="text" name="nome" autocomplete="off" class="form-control" required="required" placeholder="Fulano da silva">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="col-form-label">E-mail</label>
                                                        <input type="email" name="email" autocomplete="off" class="form-control" required="required" placeholder="exemplo@exemplo.com">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">CPF</label>
                                                        <input type="text" name="cpf_cnpj" id="cpf" autocomplete="off" required="required" class="form-control" placeholder="123.456.789-00">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Sexo</label>
                                                        <select name="sexo" id="sexo">
                                                            <option value="" selected>Sexo </option>
                                                            <option value="M">Masculino </option>
                                                            <option value="F">Feminino </option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Data de Nascimento</label>
                                                        <input type="text" required="required" name="nascimento" id="nascimento" autocomplete="off" class="form-control datepicker" placeholder="01/01/2000">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Nacionalidade</label>
                                                        <input type="text" required="required" name="nacionalidade" autocomplete="off" class="form-control" placeholder="Brasileiro">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Número CNH</label>
                                                        <input type="text" required="required" name="cnh" autocomplete="off" class="form-control" placeholder="12345678901">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Validade CNH</label>
                                                        <input type="text" required="required" name="validade_cnh" id="validade_cnh" autocomplete="off" class="form-control datepicker" placeholder="01/01/2000">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Categoria CNH</label>
                                                        <select name="categoria_cnh" id="categoria_cnh">
                                                            <option value="0" selected>Selecione uma Categoria </option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Celular</label>
                                                        <input type="text" required="required" name="celular" autocomplete="off" class="form-control" placeholder="(11) 99999-8888">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Número RG</label>
                                                        <input type="text" required="required" name="rg" autocomplete="off" class="form-control" placeholder="123456789">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Emissor</label>
                                                        <input type="text" required="required" name="emissor" autocomplete="off" class="form-control" placeholder="SSP">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label class="col-form-label">CEP</label>
                                                        <div class="form-inline">
                                                            <input type="text" required="required" name="cep" autocomplete="off" class="form-control mr-sm-2" placeholder="12345-577">
                                                            <button type="button" class="btn btn-info waves-effect waves-light my-2 my-sm-0" id="search_cep"><i class="fa fa-search"></i></button>
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label class="col-form-label">Endereço</label>
                                                        <input type="text" required="required" name="endereco" autocomplete="off" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label class="col-form-label">Número</label>
                                                        <input type="text" required="required" name="numero" autocomplete="off" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Complemento</label>
                                                        <input type="text" name="complemento" autocomplete="off" class="form-control" placeholder="Casa 90">
                                                    </div>

                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Bairro</label>
                                                        <input type="text" required="required" name="bairro" autocomplete="off" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-5">
                                                        <label class="col-form-label">Cidade</label>
                                                        <input type="text" required="required" name="cidade" autocomplete="off" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-1">
                                                        <label class="col-form-label">Estado</label>
                                                        <input type="text" required="required" name="estado" autocomplete="off" class="form-control" placeholder="SP">
                                                    </div>
                                                </div>

                                            </div>

                                            <!-- Form de pessoa juridica -->
                                            <div id="cadastro-pessoa-juridica" style="display: none;">

                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label class="col-form-label">Nome Completo</label>
                                                        <input type="text" required="required" name="nome_pj" autocomplete="off" class="form-control" placeholder="Fulano da silva">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="col-form-label">E-mail</label>
                                                        <input type="email" required="required" name="email_pj" autocomplete="off" class="form-control" placeholder="exemplo@exemplo.com">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-12">
                                                        <label class="col-form-label">CNPJ</label>
                                                        <input type="text" required="required" name="cpf_cnpj_pj" id="cnpj" autocomplete="off" class="form-control" placeholder="86.922.470/0001-28">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Número CNH</label>
                                                        <input type="text" required="required" name="cnh_pj" autocomplete="off" class="form-control" placeholder="12345678901">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Validade CNH</label>
                                                        <input type="text" required="required" name="validade_cnh_pj" id="validade_cnh_pj" autocomplete="off" class="form-control datepicker" placeholder="01/01/2000">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Categoria CNH</label>
                                                        <select name="categoria_cnh" id="categoria_cnh_pj">
                                                            <option value="0" selected>Selecione uma Categoria </option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Celular</label>
                                                        <input type="text" required="required" name="celular_pj" autocomplete="off" class="form-control" placeholder="(11) 99999-8888">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label class="col-form-label">CEP</label>
                                                        <div class="form-inline">
                                                            <input type="text" required="required" name="cep_pj" autocomplete="off" class="form-control mr-sm-2" placeholder="12345-577">
                                                            <button type="button" class="btn btn-info waves-effect waves-light my-2 my-sm-0" id="search_cep_pj"><i class="fa fa-search"></i></button>
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label class="col-form-label">Endereço</label>
                                                        <input type="text" required="required" name="endereco_pj" autocomplete="off" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label class="col-form-label">Número</label>
                                                        <input type="text" required="required" name="numero_pj" autocomplete="off" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Complemento</label>
                                                        <input type="text" name="complemento_pj" autocomplete="off" class="form-control" placeholder="Casa 90">
                                                    </div>

                                                    <div class="form-group col-md-3">
                                                        <label class="col-form-label">Bairro</label>
                                                        <input type="text" required="required" name="bairro_pj" autocomplete="off" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-5">
                                                        <label class="col-form-label">Cidade</label>
                                                        <input type="text" required="required" name="cidade_pj" autocomplete="off" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-1">
                                                        <label class="col-form-label">Estado</label>
                                                        <input type="text" required="required" name="estado_pj" autocomplete="off" class="form-control" placeholder="SP">
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="cancelar" class="btn btn-secondary waves-effect" data-dismiss="modal">
                                                Cancelar
                                            </button>
                                            <button type="button" id="enviar" class="btn btn-success waves-effect waves-light">
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

        <script src="../scripts/clientes-script.js"></script>

    </body>
</html>