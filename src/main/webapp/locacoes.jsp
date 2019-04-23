<%--suppress ALL --%>
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
                                        <li class="breadcrumb-item active">Cadastro de Locações</li>
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
                                                    <i class="ti-user"></i> Locações
                                                </h3>

                                                <div class="portlet-widgets">
                                                    <button id="cadastro_button"
                                                            class="btn btn-outline-success btn-rounded waves-effect waves-light"
                                                            data-toggle="modal"
                                                            data-target="#cadastro">
                                                        <i class="ti-plus"></i>
                                                        Criar uma locação
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
                                                                    <th> Veiculo</th>
                                                                    <th> Cliente</th>
                                                                    <th> Data da locação</th>
                                                                    <th> Dias restantes</th>
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
                                            <h4 class="modal-title" id="CenterModalLabel">Cadastro de Locações</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-row">
                                                <label class="col-form-label">CPF/CNPJ</label>
                                                <div class="input-group" id="default-daterange">
                                                    <input type="text" name="cpf_cnpj" id="cpf_cnpj" class="form-control" placeholder="Digite o CPF ou CNPJ do cliente">
                                                    <span class="input-group-append">
                                                        <button type="button" id="search_client" class="btn btn-primary"><i class="fa fa-search"></i></button>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label class="col-form-label">Nome</label>
                                                    <input type="text" name="nome" autocomplete="off" class="form-control" disabled>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label class="col-form-label">CNH</label>
                                                    <input type="text" name="cnh" autocomplete="off" class="form-control" disabled>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label class="col-form-label">Validade CNH</label>
                                                    <input type="text" name="validade_cnh" autocomplete="off" class="form-control" disabled>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-9">
                                                    <label class="col-form-label">Veículo</label>
                                                    <select name="veiculo" id="veiculos">
                                                        <option value="" selected>Escolha o veículo </option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label class="col-form-label">Valor diário</label>
                                                    <input type="text" name="veiculo_valor" autocomplete="off" class="form-control" disabled>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-3">
                                                    <label class="col-form-label">Quantidade de dias</label>
                                                    <input type="text" name="qtd_dias" autocomplete="off" class="form-control">
                                                </div>  
                                            </div>
                                            <div class="form-row">
                                                <label class="col-form-label">Observações</label>
                                                <textarea class="form-control" id="clipboard-textarea" rows="5"></textarea>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-9"></div>
                                                <div class="form-group col-md-3">
                                                    <label class="col-form-label">Valor Total</label>
                                                    <input type="text" name="valor_aluguel" autocomplete="off" class="form-control" disabled>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="cancelar" class="btn btn-secondary waves-effect" data-dismiss="modal">
                                                Cancelar
                                            </button>
                                            <button type="button" id="enviar" class="btn btn-success waves-effect waves-light">
                                                Cadastrar
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
                $('#validade_cnh').mask('00/00/0000');
                $('#veiculos').select2({
                    dropdownParent: $('#cadastro')
                });
            });

            $('#search_client').click(function() {
                $.ajax({
                    url: 'cliente/search',
                    data: {
                        'cpf': $('#cpf_cnpj').val()
                    },
                    type: 'GET',
                    success: function (data) {
                        console.log(data);
                    },
                    error: function () {
                        JOptionPane.showMessageDialog('error', 'Cliente inexistente');
                    }
                });
            });

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
            }

        </script>



    </body>
</html>