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
                                                            data-target="#filters">
                                                        <i class="ion-funnel"></i>
                                                        Filtros
                                                    </button>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div id="bg-inverse" class="panel-collapse collapse show">
                                                <div class="portlet-body">
                                                    <div class="table-responsive mt-3">
                                                        <table id="tbl_relatorio" class="table table-bordered" style="width:100%;">
                                                            <thead>
                                                                <tr>
                                                                    <th>#</th>
                                                                    <th> Cliente</th>
                                                                    <th> Categoria</th>
                                                                    <th> Veículo</th>
                                                                    <th> Placa</th>
                                                                    <th> Tipo Devolutiva</th>
                                                                    <th> Valor</th>
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

                        <div id="filters" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="CenterModalLabel"
                             aria-hidden="true">
                            <form class="form-horizontal" id="filtro" role="form" action="" type="POST">
                                <input type="hidden" name="id" value=""/>

                                <div class="modal-dialog modal-dialog-centered modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="CenterModalLabel">Fitros</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group row" >
                                                <label for="datetimes" class="col-md-3 col-form-label"> Data: </label>

                                                <div class="input-daterange input-group col-md-9" id="daterangepicker">
                                                    <input class="form-control input-daterange-timepicker" id="datetimes" name="datetimes" required="required" type="text" autocomplete="off">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="avaliacao" class="col-3 col-form-label">Avaliação: </label>

                                                <div class="col-md-9">
                                                    <select name="avaliacao" id="avaliacao">
                                                        <option value="">Selecione a Avaliação </option>
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
                        </div>

                    </div>
                    <!-- end container -->
                </div>
                <!-- end content -->

                <jsp:include page="footer.jsp"/>

            </div>
            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <script>
            var resizefunc = [];
                    $(document).ready(function () {

            $('#avaliacao').select2({
            dropdownParent: $('#filters')
            });
                    popSelectBox();
                    loadTable();
                    $('input[name="datetimes"]').daterangepicker({
            "autoApply": true,
                    "linkedCalendars": false,
                    "showCustomRangeLabel": false,
                    "parentEl": "#filters",
                    "locale": {
                    "format": "DD/MM/YYYY",
                            "separator": " - ",
                            "applyLabel": "Aplicar",
                            "cancelLabel": "Cancelar",
                            "fromLabel": "De",
                            "toLabel": "Até",
                            "customRangeLabel": "Customizado",
                            "daysOfWeek": [
                                    "Dom",
                                    "Seg",
                                    "Ter",
                                    "Qua",
                                    "Qui",
                                    "Sex",
                                    "Sáb"
                            ],
                            "monthNames": [
                                    "Janeiro",
                                    "Fevereiro",
                                    "Março",
                                    "Abril",
                                    "Maio",
                                    "Junho",
                                    "Julho",
                                    "Agosto",
                                    "Setembro",
                                    "Outubro",
                                    "Novembro",
                                    "Dezembro"
                            ],
                            "firstDay": 1
                    }
            });
                    getFilterData();
            });
                    function popSelectBox()
                    {
                    $.ajax({
                    url: "getavaliacao",
                            type: 'GET',
                            success: function (data) {
                            $('#avaliacao').empty();
                                    $('<option>').val(0).text("Todas").appendTo('#avaliacao'); // aqui defino a primeira opção para orientar o usuario
                                    for (var i in data)
                            {
                            console.log(data[i])
                                    var options = $('<option>').val(data[i].id).text(data[i].avaliacao);
                                    options.appendTo('#avaliacao');
                            }
                            },
                            error: function () {
                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os Status dos Veículos!');
                            }
                    });
                    }

            function getFilterData()
            {
            let data = {};
                    let datePart = $('#datetimes').val().split("-");
                    if (datePart[0] === "") {
            data.dateIni = moment().format("YYYY-MM-DD");
                    data.dateFim = moment().format("YYYY-MM-DD");
                    data.avaliacao = 0;
            } else {
            data.dateIni = moment(moment(datePart[0].trim(), "DD/mm/YYYY")).format("YYYY-mm-DD");
                    data.dateFim = moment(moment(datePart[1].trim(), "DD/mm/YYYY")).format("YYYY-mm-DD");
                    data.avaliacao = $('#avaliacao').val()
            }

            return data;
            }

            $("#filtro").submit(function(e) {
            e.preventDefault();
                    loadTable();
                    $('#filters').modal('hide');
            });
                    var me = this;
                    function loadTable()
                    {
                    $.ajax({
                    url: "getlocacoes",
                            type: 'POST',
                            data: getFilterData(),
                            success: function (result) {
                            popTable(result);
                            },
                            error: function () {
                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                            }
                    });
                    }

            function popTable(data)
            {
            $('#tbl_relatorio tr').not(':first').remove(); //Aqui eu limpo a tabela
                    let contador = 1
                    var html = ''; // Aqui declaro a variável que receberá o conteúdo HTML
                    for (var i in data) { // aqui faço um FOREACH, para a minha lista de dados. Cada linha de dado, preencho uma linha na tabela
            html = '<tr><td>' + (contador++) + '</td>' +
                    '<td>' + data[i].cliente + '</td>' +
                    '<td>' + data[i].categoriaCliente + '</td>' +
                    '<td>' + data[i].veiculo + '</td>' +
                    '<td>' + data[i].placa + '</td>' +
                    '<td>' + data[i].tipoDevolutiva + '</td>' +
                    '<td>' + data[i].valor + '</td>' +
                    '<td>' + data[i].avaliacao + '</td>' +
                    '<td>' + moment(moment(data[i].dataLocacao, "YYYY-mm-DD")).format("DD/mm/YYYY") + '</td>' +
                    '<td>' + moment(moment(data[i].dataDevolucao, "YYYY-mm-DD")).format("DD/mm/YYYY") + '</td></tr>';
                    $('#tbl_relatorio tr').last().after(html);
            }
            }


        </script>

        <!-- Plugins  -->

    </body>
</html>