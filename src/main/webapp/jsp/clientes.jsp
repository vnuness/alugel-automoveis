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
                                                    <div class="col-12">
                                                        <div class="radio radio-primary">
                                                            <input name="categoria_cliente" id="radio-pessoa-fisica" checked="checked" value="1" type="radio">
                                                            <label for="radio-pessoa-fisica">
                                                                Pessoa Física
                                                            </label>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="col-md-3 form-group row col-form-label">
                                                    <div class="col-12">
                                                        <div class="radio radio-primary">
                                                            <input name="categoria_cliente" id="radio-pessoa-juridica" value="2" type="radio">
                                                            <label for="radio-pessoa-juridica">
                                                                Pessoa Jurídica
                                                            </label>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="col-md-3 form-group row col-form-label">
                                                    <div class="col-12">
                                                        <div class="radio radio-primary">
                                                            <input name="categoria_cliente" id="radio-motorista-app" value="3" type="radio">
                                                            <label for="radio-motorista-app">
                                                                Motorista de Aplicativo
                                                            </label>
                                                        </div>

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

        <script>
            $(document).ready(function () {

                $(".datepicker").datepicker({
                    format: 'dd/mm/yyyy',
                    language: 'pt-BR'
                });
                $("#cadastro-pessoa-juridica").hide();
                $('#sexo ,#categoria_cnh, #categoria_cnh_pj').select2({
                    dropdownParent: $('#cadastro')
                });
                $('#cpf').mask('000.000.000-00');
                $('#cnpj').mask('00.000.000/0000-00');
                $('input[name=validade_cnh]').mask('00/00/0000');
                $('input[name=celular]').mask('(00) 00000-0000');
                $('input[name=cep]').mask('00000-000');
                $('input[name=cnh]').mask('00000000000');
                $('input[name=nascimento_pj]').mask('00/00/0000');
                $('input[name=validade_cnh_pj]').mask('00/00/0000');
                $('input[name=celular_pj]').mask('(00) 00000-0000');
                $('input[name=cep_pj]').mask('00000-000');
                $('input[name=cnh_pj]').mask('00000000000');
                loadTable(0);
                popSelectBox();
                $('input[name=categoria_cliente]').click(function () {
                    var value = $(this).val();
                    if (value == 1 || value == 3) {
                        $("#cadastro-pessoa-juridica").hide();
                        $("#cadastro-pessoa-fisica").show();
                    } else if (value == 2) {
                        $("#cadastro-pessoa-fisica").hide();
                        $("#cadastro-pessoa-juridica").show();
                    }
                });
            });
            function popSelectBox()
            {
                $.ajax({
                    url: "../cliente/categoria-cnh",
                    type: 'GET',
                    success: function (data) {
                        console.log(data);
                        $('#categoria_cnh').empty();
                        $('#categoria_cnh_pj').empty();
                        $('<option>').val(0).text("Selecione uma Categoria").appendTo('#categoria_cnh');
                        $('<option>').val(0).text("Selecione uma Categoria").appendTo('#categoria_cnh_pj');
                        for (var i in data) {
                            var options = $('<option>').val(data[i].id).text(data[i].categoria);
                            options.appendTo('#categoria_cnh');
                        }
                        for (var i in data) {
                            var options = $('<option>').val(data[i].id).text(data[i].categoria);
                            options.appendTo('#categoria_cnh_pj');
                        }
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro as categorias de CNH!');
                    }
                });
                $.ajax({
                    url: "../cliente/sexo",
                    type: 'GET',
                    success: function (data) {
                        console.log(data);
                        $('#sexo').empty();
                        $('<option>').val(0).text("Selecione...").appendTo('#sexo');
                        for (var i in data) {
                            var options = $('<option>').val(data[i].id).text(data[i].sexo);
                            options.appendTo('#sexo');
                        }
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro as categorias de CNH!');
                    }
                });
            }

            $('#search_cep, #search_cep_pj').click(function () {
                var cep;
                var tipo = $('input[name=categoria_cliente]:checked').val();
                tipo == 2 ? cep = $('input[name=cep_pj]').unmask().val() : cep = $('input[name=cep]').unmask().val()

                $.ajax({
                    url: 'https://viacep.com.br/ws/' + cep + '/json/',
                    type: 'GET',
                    success: function (data) {
                        if (data.erro == true) {
                            JOptionPane.showMessageDialog('warning', 'CEP não encontrado! Por favor, digite novamente ou preencha os campos manualmente.');
                            $('input[name=cep_pj]').val('');
                            $('input[name=cep]').val('');
                        }
                        if (tipo == 1 || tipo == 3) {
                            $('input[name=endereco]').val(data.logradouro);
                            $('input[name=bairro]').val(data.bairro);
                            $('input[name=cidade]').val(data.localidade);
                            $('input[name=estado]').val(data.uf);
                            $('input[name=numero]').focus();
                        } else if (tipo == 2) {
                            $('input[name=endereco_pj]').val(data.logradouro);
                            $('input[name=bairro_pj]').val(data.bairro);
                            $('input[name=cidade_pj]').val(data.localidade);
                            $('input[name=estado_pj]').val(data.uf);
                            $('input[name=numero_pj]').focus();
                        }
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao consultar o CEP! Por favor, tente novamente ou preencha os campos manualmente');
                    }
                });
            });
            function loadTable(id)
            {

                $.ajax({
                    url: "../cliente",
                    type: 'GET',
                    data: {
                        'id': id
                    },
                    success: function (result) {
                        popTable(result);
                        return result;
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                    }
                });
            }


            function popTable(data)
            {
                $('#tbl_clientes tr').not(':first').remove(); //Aqui eu limpo a tabela
                var html = ''; // Aqui declaro a variável que receberá o conteúdo HTML
                for (var i in data) { // aqui faço um FOREACH, para a minha lista de dados. Cada linha de dado, preencho uma linha na tabela
                    html = '<tr><td>' + data[i].id + '</td>' +
                            '<td>' + data[i].nome + '</td>' +
                            '<td>' + data[i].categoria + '</td>' +
                            '<td>' + data[i].cpfCnpj + '</td>' +
                            '<td>' + data[i].email + '</td>';
                    if (data[i].status === "Ativo") {
                        html += '<td><span class="badge label-table badge-success">' + data[i].status + '</span></td>';
                    } else {
                        html += '<td><span class="badge label-table badge-danger">' + data[i].status + '</span></td>';
                    }

                    if (data[i].status === "Ativo") {
                        html += '<td style="text-align: center;"><button onClick="edit(' + data[i].id + ')" type="button" id="editar" class="btn btn-primary btn-sm waves-effect" data-id="\' + data[i].id + \'">Editar</button> <button type="button" onClick="inativar(' + data[i].id + ')" data-id="' + data[i].id + '" id="excluir" class="btn btn-danger btn-sm waves-effect waves-light">Desativar</button></td>'
                    }
                    else {
                        html += ' <td style="text-align: center;"><button type="button" onClick="ativar(' + data[i].id + ')" data-id="' + data[i].id + '" id="excluir" class="btn btn-success btn-sm waves-effect waves-light">Ativar</button></td>'
                    }

                    +'</tr>';
                    $('#tbl_clientes tr').last().after(html);
                }
            }
            /*
             *
             * @type type
             * success, question, warning, error
             */
            //Aqui é um Objeto que dentro possui um método. Criei dessa forma para ficar parecido com o que usávamos no JAVA SWING
            //É necessário passar dois parametros para a funcao. Type e Message. Type definirá o tipo do POP UP. e Message, definirá a Mensagem que será exibida no PopUP
            JOptionPane = {
                showMessageDialog: function (type, message) {
                    var title;
                    switch (type) {
                        case 'error':
                            title = 'Ops!';
                            break;
                        case 'warning':
                            title = 'Atenção';
                            break;
                        case 'success':
                            title = 'Sucesso';
                            break;
                        default:
                            title = 'Aguarde';
                            break;
                    }

                    return swal({
                        title: title,
                        text: message,
                        type: type,
                        showCancelButton: false,
                        confirmButtonClass: 'btn btn-confirm mt-2',
                        confirmButtonText: 'OK!'
                    })
                }
            }


            function pegarDados(action, tipo)
            {
                if (action === "salvar") {
                    if (tipo == '1' || tipo == '3') {
                        return {
                            'url': '../cliente/pf/salvar',
                            'data': {
                                'tipo': tipo,
                                'nome': $('input[name=nome]').val(),
                                'email': $('input[name=email]').val(),
                                'cpf_cnpj': $('input[name=cpf_cnpj]').unmask().val(),
                                'sexo': $('#sexo').val(),
                                'nascimento': moment(moment($('input[name=nascimento]').val(), "DD/mm/YYYY")).format("YYYY-mm-DD"),
                                'nacionalidade': $('input[name=nacionalidade]').val(),
                                'cnh': $('input[name=cnh]').val(),
                                'validade_cnh': moment(moment($('input[name=validade_cnh]').val(), "DD/mm/YYYY")).format("YYYY-mm-DD"),
                                'categoria_cnh': $('#categoria_cnh').val(),
                                'celular': $('input[name=celular]').val(),
                                'rg': $('input[name=rg]').val(),
                                'emissor': $('input[name=emissor]').val(),
                                'cep': $('input[name=cep]').val(),
                                'endereco': $('input[name=endereco]').val(),
                                'numero': $('input[name=numero]').val(),
                                'complemento': $('input[name=complemento]').val(),
                                'bairro': $('input[name=bairro]').val(),
                                'cidade': $('input[name=cidade]').val(),
                                'estado': $('input[name=estado]').val()
                            }

                        }
                    } else if (tipo == '2') {
                        return {
                            url: '../cliente/pj/salvar',
                            data: {
                                'tipo': tipo,
                                'nome': $('input[name=nome_pj]').val(),
                                'email': $('input[name=email_pj]').val(),
                                'cpf_cnpj': $('input[name=cpf_cnpj_pj]').unmask().val(),
                                'cnh': $('input[name=cnh_pj]').val(),
                                'validade_cnh': moment(moment($('input[name=validade_cnh_pj]').val(), "DD/mm/YYYY")).format("YYYY-mm-DD"),
                                'categoria_cnh': $('#categoria_cnh_pj').val(),
                                'celular': $('input[name=celular_pj]').unmask().val(),
                                'endereco': $('input[name=endereco_pj]').val(),
                                'cep': $('input[name=cep_pj]').unmask().val(),
                                'bairro': $('input[name=bairro_pj]').val(),
                                'numero' : $('input[name=numero_pj]').val(),
                                'cidade': $('input[name=cidade_pj]').val(),
                                'estado': $('input[name=estado_pj]').val()
                            }

                        }

                    }

                } else if (action === "editar") {
                    if ($('input:radio[name=categoria_cliente]:checked').val() == '1' || $('input:radio[name=categoria_cliente]:checked').val() == '3') {
                        return {
                            'id': $('input[name=id]').val(),
                            'nome': $('input[name=nome]').val(),
                            'email': $('input[name=email]').val(),
                            'cpf_cnpj': $('input[name=cpf_cnpj]').val(),
                            'sexo': $('#sexo').val(),
                            'nascimento': moment($('input[name=nascimento]').val(), "DD/mm/YYYY").format("YYYY-mm-DD"),
                            'nacionalidade': $('input[name=nacionalidade]').val(),
                            'cnh': $('input[name=cnh]').val(),
                            'validade_cnh': moment(moment($('#validade_cnh').val(), "DD/mm/YYYY")).format("YYYY-mm-DD"),
                            'categoria_cnh': $('#categoria_cnh').val(),
                            'celular': $('input[name=celular]').val(),
                            'rg': $('input[name=rg]').val(),
                            'numero': $('input[name=numero]').val(),
                            'emissor': $('input[name=emissor]').val(),
                            'endereco': $('input[name=endereco]').val(),
                            'complemento': $('input[name=complemento]').val(),
                            'cep': $('input[name=cep]').val(),
                            'categoria_cliente': $('input:radio[name=categoria_cliente]:checked').val(),
                            'estado': $('input[name=estado]').val(),
                            'bairro': $('input[name=bairro]').val(),
                            'cidade': $('input[name=cidade]').val()
                        }
                    } else {
                        return {
                            'id': $('input[name=id]').val(),
                            'nome': $('input[name=nome_pj]').val(),
                            'email': $('input[name=email_pj]').val(),
                            'cpf_cnpj': $('input[name=cpf_cnpj_pj]').unmask().val(),
                            'cnh': $('input[name=cnh_pj]').val(),
                            'validade_cnh': moment(moment($('input[name=validade_cnh_pj]').val(), "DD/mm/YYYY")).format("YYYY-mm-DD"),
                            'categoria_cnh': $('#categoria_cnh_pj').val(),
                            'celular': $('input[name=celular_pj]').unmask().val(),
                            'endereco': $('input[name=endereco_pj]').val(),
                            'cep': $('input[name=cep_pj]').unmask().val(),
                            'complemento': $("input[name=complemento_pj]").unmask().val(),
                            'categoria_cliente': $('input:radio[name=categoria_cliente]:checked').val(),
                            'bairro': $('input[name=bairro_pj]').val(),
                            'cidade': $('input[name=cidade_pj]').val(),
                            'estado': $('input[name=estado_pj]').val(),
                            'numero': $('input[name=numero_pj]').val()
                        }
                    }
                }

            }

            $('#enviar').click(function (e) {
                e.preventDefault();
                if ($("#enviar").hasClass("editar")) {

                    if ($('input:radio[name=categoria_cliente]:checked').val() == '1' || $('input:radio[name=categoria_cliente]:checked').val() == '3') {
                        if (validarFormularioPf()) {
                            $.ajax({
                                url: "../cliente/pf/atualizar",
                                type: 'POST',
                                data: pegarDados('editar', $('input:radio[name=categoria_cliente]:checked').val()),
                                success: function (result) {

                                    if (result.return === "success") {
                                        JOptionPane.showMessageDialog('success', 'Cliente atualizado com sucesso!');
                                        limparFormulario();
                                        $('#enviar').removeClass('editar');
                                        $('#cadastro').modal('hide');
                                        loadTable(0);
                                    } else {
                                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Cliente!');
                                    }
                                },
                                error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Cliente!');
                                }
                            });
                        }
                    } else {
                        if (validarFormularioPj()) {
                            $.ajax({
                                url: "../cliente/pj/atualizar",
                                type: 'POST',
                                data: pegarDados('editar', $('input:radio[name=categoria_cliente]:checked').val()),
                                success: function (result) {

                                    if (result.return === "success") {
                                        JOptionPane.showMessageDialog('success', 'Cliente atualizado com sucesso!');
                                        limparFormulario();
                                        $('#enviar').removeClass('editar');
                                        $('#cadastro').modal('hide');
                                        loadTable(0);
                                    } else {
                                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Cliente!');
                                    }
                                },
                                error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Cliente!');
                                }
                            });
                        }
                    }

                } else {

                    if ($('input[name=categoria_cliente]:checked').val() == '1' || $('input[name=categoria_cliente]:checked').val() == '3') {
                        if (validarFormularioPf()) {
                            var dados = pegarDados('salvar', $('input[name=categoria_cliente]:checked').val());
                            $.ajax({
                                url: dados.url,
                                type: 'POST',
                                data: dados.data,
                                success: function (result) {
                                    console.log(result.return);
                                    if (result.return == "success") {
                                        JOptionPane.showMessageDialog('success', 'Cliente cadastrado com sucesso!');
                                        limparFormulario();
                                        $('#cadastro').modal('hide');
                                        loadTable(0);
                                    } else {
                                        JOptionPane.showMessageDialog('error', 'Cliente um erro ao cadastrar o Cliente!');
                                    }
                                },
                                error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao Cadastrar o Cliente!');
                                }
                            });
                        }
                    } else {
                        if (validarFormularioPj()) {
                            var dados = pegarDados('salvar', $('input[name=categoria_cliente]:checked').val());
                            $.ajax({
                                url: dados.url,
                                type: 'POST',
                                data: dados.data,
                                success: function (result) {
                                    console.log(result.return);
                                    if (result.return == "success") {
                                        JOptionPane.showMessageDialog('success', 'Cliente cadastrado com sucesso!');
                                        limparFormulario();
                                        $('#cadastro').modal('hide');
                                        loadTable(0);
                                    } else {
                                        JOptionPane.showMessageDialog('error', 'Cliente um erro ao cadastrar o Cliente!');
                                    }
                                },
                                error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao Cadastrar o Cliente!');
                                }
                            });
                        }
                    }
                }
            });
            function edit(id) {
                $.ajax({
                    url: "../cliente/get-cliente",
                    type: 'GET',
                    data: {
                        'id': id
                    },
                    success: function (result) {
                        console.log(result);
                        for (var i in result) {
                            setFields(result[i]);
                        }
                        $('input:radio[name=categoria_cliente]').attr("disabled", "disabled");
                        $('#enviar').addClass("editar");
                        $('#cadastro').modal('show');
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                    }
                });
            }

            $('#cadastro').on('hidden.bs.modal', function () {
                limparFormulario();
            });
            function inativar(id)
            {

                swal({
                    title: 'Você tem certeza que deseja desativar este cliente?',
                    text: "",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    cancelButtonText: 'Não',
                    confirmButtonText: 'Sim'
                }).then((result) = function () {
                    $.ajax({
                        url: "../cliente/inativar",
                        type: 'POST',
                        data: {
                            'excluir': 'true',
                            'id': id
                        },
                        success: function () {
                            JOptionPane.showMessageDialog('success', 'Cliente Desativado com sucesso!');
                            loadTable(0);
                        },
                        error: function () {
                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao desativar o Cliente!');
                        }
                    });
                });
            }

            function ativar(id)
            {
                $.ajax({
                    url: '../cliente/ativar',
                    type: 'POST',
                    data: {
                        'id': id
                    },
                    success: function () {
                        JOptionPane.showMessageDialog('success', 'Cliente Ativado com sucesso!');
                        loadTable(0);
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao ativar o Cliente!');
                    }
                })
            }

            function setFields(data)
            {
                $('input[name=id]').val(data.id)
                if (data.idCategoriaCliente == 1 || data.idCategoriaCliente == 3) {
                    if (data.idCategoriaCliente == 1) {
                        $("#cadastro-pessoa-juridica").hide();
                        $("#cadastro-pessoa-fisica").show();
                        $('input:radio[name=categoria_cliente]').filter('[value=1]').prop('checked', true);
                    } else {
                        $('input:radio[name=categoria_cliente]').filter('[value=3]').prop('checked', true);
                    }
                    $('input[name=nome]').val(data.nome);
                    $('input[name=email]').val(data.email);
                    $('input[name=cpf_cnpj]').val(data.cpfCnpj);
                    $('#sexo').val(data.idsexo).trigger('change');
                    $('input[name=nascimento]').val(moment(data.dataNascimento, "YYYY-MM-DD").format("DD/MM/YYYY"));
                    $('input[name=nacionalidade]').val(data.nacionalidade);
                    $('input[name=cnh]').val(data.cnh);
                    $('input[name=validade_cnh]').val(moment(data.validadeCnh, "YYYY-MM-DD").format("DD/MM/YYYY"));
                    $('#categoria_cnh').val(data.idCategoriaCnh).trigger('change');
                    $('input[name=celular]').val(data.celular);
                    $('input[name=rg]').val(data.rg);
                    $('input[name=emissor]').val('SSP');
                    $('input[name=endereco]').val(data.endereco);
                    $('input[name=complemento]').val(data.complemento);
                    $('input[name=cep]').val(data.cep);
                    $('input[name=numero]').val(data.numero);
                    $('input[name=estado]').val(data.estado);
                    $('input[name=bairro]').val(data.bairro);
                    $('input[name=cidade]').val(data.cidade);
                } else if (data.idCategoriaCliente == 2) {
                    $('input:radio[name=categoria_cliente]').filter('[value=2]').prop('checked', true);
                    $("#cadastro-pessoa-fisica").hide();
                    $("#cadastro-pessoa-juridica").show();
                    $('input[name=nome_pj]').val(data.nome);
                    $('input[name=email_pj]').val(data.email);
                    $('input[name=cpf_cnpj_pj]').val(data.cpfCnpj);
                    $('input[name=cnh_pj]').val(data.cnh);
                    $('input[name=validade_cnh_pj]').val(moment(data.validadeCnh, "YYYY-MM-DD").format("DD/MM/YYYY"));
                    $('input[name=cnh_pj]').val(data.cnh);
                    $('#categoria_cnh_pj').val(data.idCategoriaCnh).trigger('change');
                    $('input[name=celular_pj]').val(data.celular);
                    $('input[name=cep_pj]').val(data.cep);
                    $('input[name=endereco_pj]').val(data.endereco);
                    $('input[name=numero_pj]').val(data.numero);
                    $('input[name=complemento_pj]').val(data.complemento);
                    $('input[name=bairro_pj]').val(data.bairro);
                    $('input[name=cidade_pj]').val(data.cidade);
                    $('input[name=estado_pj]').val(data.estado);
                }

            }

            function validarFormularioPf() {

                if ($("input[name=nome]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo nome!');
                    return false;
                }

                if ($("input[name=email]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo email!');
                    return false;
                }

                if ($("input[name=cpf_cnpj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo CPF!');
                    return false;
                }

                if ($("#sexo").val() == 0) {
                    JOptionPane.showMessageDialog('warning', 'Selecione um sexo!');
                    return false;
                }

                if ($("input[name=nascimento]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Selecione uma data de nascimento!');
                    return false;
                }
                

                if ($("input[name=nacionalidade]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo nacionalidade!');
                    return false;
                }

                if ($("input[name=cnh]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo CNH!');
                    return false;
                }

                if ($("input[name=validade_cnh]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Selecione uma data de validade da CNH!');
                    return false;
                }

                if ($("#categoria_cnh").val() == 0) {
                    JOptionPane.showMessageDialog('warning', 'Selecione uma categoria de CNH!');
                    return false;
                }

                if ($("input[name=celular]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo celular!');
                    return false;
                }

                if ($("input[name=rg]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo RG!');
                    return false;
                }

                if ($("input[name=emissor]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo Emissor!');
                    return false;
                }

                if ($("input[name=cep]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo CEP!');
                    return false;
                }

                if ($("input[name=endereco]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo endereço!');
                    return false;
                }

                if ($("input[name=numero]").val() == '' || !isNumber($("input[name=numero]").val())) {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo número');
                    return false;
                }

                if ($("input[name=bairro]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo bairro!');
                    return false;
                }

                if ($("input[name=cidade]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo cidade!');
                    return false;
                }

                if ($("input[name=estado]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo estado!');
                    return false;
                }

                return true;
            }

            function validarFormularioPj() {

                if ($("input[name=nome_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo nome!');
                    return false;
                }

                if ($("input[name=email_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo email!');
                    return false;
                }

                if ($("input[name=cpf_cnpj_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo CPF!');
                    return false;
                }

                if ($("input[name=cnh_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo CNH!');
                    return false;
                }

                if ($("input[name=validade_cnh_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Selecione uma data de validade da CNH!');
                    return false;
                }

                if ($("#categoria_cnh_pj").val() == 0) {
                    JOptionPane.showMessageDialog('warning', 'Selecione uma categoria de CNH!');
                    return false;
                }

                if ($("input[name=celular_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo celular!');
                    return false;
                }

                if ($("input[name=cep_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo CEP!');
                    return false;
                }

                if ($("input[name=endereco_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo endereço!');
                    return false;
                }

                if ($("input[name=numero_pj]").val() == '' || !isNumber($("input[name=numero_pj]").val())) {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo número');
                    return false;
                }

                if ($("input[name=bairro_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo bairro!');
                    return false;
                }

                if ($("input[name=cidade_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo cidade!');
                    return false;
                }

                if ($("input[name=estado_pj]").val() == '') {
                    JOptionPane.showMessageDialog('warning', 'Preencha um valor no campo estado!');
                    return false;
                }

                return true;
            }

            function limparFormulario()
            {
                $('input[name=id]').val();
                $('input:radio[name=categoria_cliente]').filter('[value=1]').prop('checked', true);
                $("#cadastro-pessoa-juridica").hide();
                $("#cadastro-pessoa-fisica").show();
                $('input[name=nome]').val('');
                $('input[name=nome_pj]').val('');
                $('input[name=email]').val('');
                $('input[name=email_pj]').val('');
                $('input[name=cpf_cnpj]').val('');
                $('input[name=cpf_cnpj_pj]').val('');
                $('input[name=sexo]').val(0).trigger('change');
                $('input[name=nascimento]').val('');
                $('input[name=nacionalidade]').val('');
                $('input[name=cnh]').val('');
                $('input[name=cnh_pj]').val('');
                $('input[name=validade_cnh]').val('');
                $('input[name=validade_cnh_pj]').val('');
                $('input[name=categoria_cnh]').val(0).trigger('change');
                $('input[name=celular]').val('');
                $('input[name=celular_pj]').val('');
                $('input[name=rg]').val('');
                $('input[name=emissor]').val('');
                $('input[name=endereco]').val('');
                $('input[name=endereco_pj]').val('');
                $('input[name=complemento]').val('');
                $('input[name=complemento_pj]').val('');
                $('input[name=numero]').val('');
                $('input[name=numero_pj]').val('');
                $('input[name=cep]').val('');
                $('input[name=cep_pj]').val('');
                $('input[name=bairro]').val('');
                $('input[name=bairro_pj]').val('');
                $('input[name=cidade]').val('');
                $('input[name=cidade_pj]').val('');
                $('input[name=estado]').val('');
                $('input[name=estado_pj]').val('');
                $('#enviar').removeClass('editar');
                $('input:radio[name=categoria_cliente]').removeAttr("disabled");
            }

            function isNumber(n)
            {
                return !isNaN(parseFloat(n)) && isFinite(n);
            }


        </script>

    </body>
</html>