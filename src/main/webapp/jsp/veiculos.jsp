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
                                        <li class="breadcrumb-item active">Cadastro Veículos</li>
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
                                                    <i class="ion-model-s"></i> VEÍCULOS
                                                </h3>

                                                <div class="portlet-widgets">
                                                    <button id="cadastro_button"
                                                            class="btn btn-outline-success btn-rounded waves-effect waves-light"
                                                            data-toggle="modal"
                                                            data-target="#cadastro">
                                                        <i class="ti-plus"></i>
                                                        Adicionar Veículo
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
                                                                    <th> Veículo</th>
                                                                    <th> Montadora</th>
                                                                    <th> Ano</th>
                                                                    <th> Placa</th>
                                                                    <th> Renavam</th>
                                                                    <th> Combustível</th>
                                                                    <th> Câmbio</th>
                                                                    <th> Acessórios</th>
                                                                    <th> Status</th>
                                                                    <th> Valor</th>
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
                                                <label for="modelo" class="col-md-3 col-form-label"> Modelo: <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="modelo" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="montadora" class="col-md-3 col-form-label"> Montadora: <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="montadora" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="ano" class="col-md-3 col-form-label"> Ano: <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="ano" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row" >
                                                <label for="placa" class="col-md-3 col-form-label"> Placa: <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" name="placa" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="renavam" class="col-md-3 col-form-label"> Renavam: <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" required="required" name="renavam" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="valor" class="col-md-3 col-form-label"> Valor Diária <span class="required">*</span></label>

                                                <div class="input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" required="required" name="valor" type="text" autocomplete="off">
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
                                                <label for="acessorios" class="col-md-3 col-form-label"> Acessórios: <span class="required"></span></label>

                                                <div class="input-group col-md-9">
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

                $('#combustivel, #cambio, #status').select2({
                    dropdownParent: $('#cadastro')
                });
                $('input[name=placa]').mask('AAA-0000');
                loadTable(0);
                popSelectBox();


            });

            function loadTable(id)
            {
                $.ajax({
                    url: "../veiculos",
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
                $('#tbl_veiculos tr').not(':first').remove();
                var html = '';
                for (var i in data) {
                    html = '<tr><td>' + data[i].id + '</td>' +
                            '<td>' + data[i].modelo + '</td>' +
                            '<td>' + data[i].montadora + '</td>' +
                            '<td>' + data[i].ano + '</td>' +
                            '<td>' + data[i].placa + '</td>' +
                            '<td>' + data[i].renavam + '</td>' +
                            '<td>' + data[i].combustivel + '</td>' +
                            '<td>' + data[i].cambio + '</td>' +
                            '<td>' + data[i].acessorio + '</td>' +
                            '<td>' + data[i].status + '</td>' +
                            '<td>' + data[i].valor + '</td>' +
                            '<td><button onClick="edit(' + data[i].id + ')" type="button" id="editar" class="btn btn-primary btn-sm waves-effect" data-id="' + data[i].id + '">Editar</button> <button type="button" onClick="remove(' + data[i].id + ')" data-id="' + data[i].id + '" id="excluir" class="btn btn-danger btn-sm waves-effect waves-light">Inativar</button></td>'
                            + '</tr>';
                    $('#tbl_veiculos tr').last().after(html);
                }
            }
            /*
             * 
             * @type type
             * success, question, warning, error
             */
            $('#cadastro').on('hidden.bs.modal', function (e) {
                if ($("#enviar").hasClass("editar")) {
                    $("#enviar").removeClass("editar");
                    limparFormulario();
                }
            })

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
                    //SWAL é Abreviação de SWEET ALERT. SWEET ALERT é o componente que possui esses alertas pronto.
                    return swal({
                        title: title,
                        text: message,
                        type: type,
                        showCancelButton: false,
                        confirmButtonClass: 'btn btn-confirm mt-2',
                        confirmButtonText: 'OK!'
                    })
                }
            };

            function pegarDados(action)
            {
                if (action === "salvar") {
                    return {
                        'modelo': $('input[name=modelo]').val(),
                        'montadora': $('input[name=montadora]').val(),
                        'ano': $('input[name=ano]').val(),
                        'placa': $('input[name=placa]').val(),
                        'renavam': $('input[name=renavam]').val(),
                        'valor': $('input[name=valor]').val(),
                        'combustivel': $('#combustivel').val(),
                        'cambio': $('#cambio').val(),
                        'status': $('#status').val(),
                        'acessorios': $('#acessorios').val()
                    }
                } else if (action === "editar") {
                    return {
                        'id': $('input[name=id]').val(),
                        'modelo': $('input[name=modelo]').val(),
                        'montadora': $('input[name=montadora]').val(),
                        'ano': $('input[name=ano]').val(),
                        'placa': $('input[name=placa]').val(),
                        'renavam': $('input[name=renavam]').val(),
                        'valor': $('input[name=valor]').val(),
                        'combustivel': $('#combustivel').val(),
                        'cambio': $('#cambio').val(),
                        'status': $('#status').val(),
                        'acessorios': $('#acessorios').val()
                    }
                }

            }

            $('#cad-veiculos').submit(function (e) {
                e.preventDefault();
                if ($("#enviar").hasClass("editar")) {
                    if (validarFormulario()) {
                        $.ajax({
                            url: "../veiculos",
                            type: 'POST',
                            data: pegarDados('editar'),
                            success: function (result) {
                                if (result.return === "success") {
                                    JOptionPane.showMessageDialog('success', 'Produto atualizado com sucesso!');
                                    limparFormulario();
                                    $('#enviar').removeClass('editar');
                                    $('#cadastro').modal('hide');
                                    loadTable(0);
                                } else {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Produto!');
                                }
                            },
                            error: function () {
                                JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Produto!');
                            }
                        });
                    }
                } else {
                    if (validarFormulario()) {
                        $.ajax({
                            url: "../veiculos",
                            type: 'POST',
                            data: pegarDados('salvar'),
                            success: function (result) {
                                console.log(result.return);
                                if (result.return === "success") {
                                    JOptionPane.showMessageDialog('success', 'Produto cadastrado com sucesso!');
                                    limparFormulario();
                                    $('#cadastro').modal('hide');
                                    loadTable(0);
                                } else {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao cadastrar o Produto!');
                                }
                            },
                            error: function () {
                                JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao cadastrar o Produto!');
                            }
                        });
                    }
                }
            });

            function edit(id) {
                $.ajax({
                    url: "../veiculos",
                    type: 'GET',
                    data: {
                        'id': id
                    },
                    success: function (result) {
                        for (var i in result) {
                            setFields(result[i]);
                        }
                        $('#enviar').addClass("editar");
                        $('#cadastro').modal('show');
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                    }
                });

            }

            function remove(id)
            {
                swal({
                    title: 'Você tem certeza que deseja inativar este veículo?',
                    text: "",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    cancelButtonText: 'Não',
                    confirmButtonText: 'Sim'
                }).then((result) = function () {
                    $.ajax({
                        url: "../veiculos",
                        type: 'POST',
                        data: {
                            'excluir': 'true',
                            'id': id
                        },
                        success: function () {
                            swal(
                                    'Inativado!',
                                    'Veículo inativado com sucesso!.',
                                    'success'
                                    )
                            loadTable(0);
                        },
                        error: function () {
                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao excluir o Produto!');
                        }
                    });
                });

            }

            function setFields(data)
            {
                $('input[name=id]').val(data.id);
                $('input[name=modelo]').val(data.modelo);
                $('input[name=montadora]').val(data.montadora);
                $('input[name=ano]').val(data.ano);
                $('input[name=placa]').val(data.placa);
                $('input[name=renavam]').val(data.renavam);
                $('input[name=valor]').val(data.valor);
                $('#status').val(data.status).trigger('change');
                $('#combustivel').val(data.combustivel).trigger('change');
                $('#cambio').val(data.cambio).trigger('change');
                $('#acessorios').val(data.acessorio);
            }

            function popSelectBox()
            {
                $.ajax({
                    url: "../veiculos",
                    type: 'GET',
                    data: {
                        'getStatus': true
                    },
                    success: function (data) {
                        $('#status').empty();
                        $('<option>').val(0).text("Selecione o Status do Veículo").appendTo('#status');
                        for (var i in data) {
                            var options = $('<option>').val(data[i].id).text(data[i].status);
                            options.appendTo('#status');
                        }
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os Status dos Veículos!');
                    }
                });

                $.ajax({
                    url: "../veiculos",
                    type: 'GET',
                    data: {
                        'getCombustivel': true
                    },
                    success: function (data) {
                        $('#combustivel').empty();
                        $('<option>').val(0).text("Selecione o tipo de Combustível do Veículo").appendTo('#combustivel');
                        for (var i in data) {
                            var options = $('<option>').val(data[i].id).text(data[i].combustivel);
                            options.appendTo('#combustivel');
                        }
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os tipos de Combustíveis dos Veículos!');
                    }
                });

                $.ajax({
                    url: "../veiculos",
                    type: 'GET',
                    data: {
                        'getCambio': true
                    },
                    success: function (data) {
                        $('#cambio').empty();
                        $('<option>').val(0).text("Selecione o tipo de Câmbio do Veículo").appendTo('#cambio');
                        for (var i in data) {
                            var options = $('<option>').val(data[i].id).text(data[i].cambio);
                            options.appendTo('#cambio');
                        }
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os tipos de Câmbio dos Veículos!');
                    }
                });
            }

            function validarFormulario()
            {
                if (!isNumber($("input[name='ano']").val())) {
                    $("input[name='ano']").val('');
                    JOptionPane.showMessageDialog('warning', 'Digite um valor numérico no campo Ano!');
                    return false;
                }
                if (!isNumber($("input[name='renavam']").val())) {
                    JOptionPane.showMessageDialog('warning', 'Digite um valor numérico no campo Renavam!');
                    return false;
                }
                if ($("#combustivel").val() == "0") {
                    JOptionPane.showMessageDialog('warning', 'Selecione um valor no campo Combustível!');
                    return false;
                }
                if ($("#status").val() == "0") {
                    JOptionPane.showMessageDialog('warning', 'Selecione um valor no campo Status!');
                    return false;
                }
                if ($("#cambio").val() == "0") {
                    JOptionPane.showMessageDialog('warning', 'Selecione um valor no campo Câmbio');
                    return false;
                }

                return true;
            }

            function limparFormulario()
            {
                $('input[name=modelo]').val('');
                $('input[name=montadora]').val('');
                $('input[name=ano]').val('');
                $('input[name=placa]').val('');
                $('input[name=renavam]').val('');
                $('input[name=valor]').val('');
                $('#status').val('0').trigger('change');
                $('#combustivel').val('0').trigger('change');
                $('#cambio').val('0').trigger('change');
                $('#acessorios').val('');
            }

            function isNumber(n)
            {

                return !isNaN(parseFloat(n)) && isFinite(n);
            }


        </script>



    </body>
</html>