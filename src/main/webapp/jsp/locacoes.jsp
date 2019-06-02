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
                                                    <i class="fa fa-usd"></i> Locações
                                                </h3>

                                                <div class="portlet-widgets">
                                                    <!--<button id="cadastro_button"
                                                            class="btn btn-outline-success btn-rounded waves-effect waves-light"
                                                            data-toggle="modal"
                                                            data-target="#cadastro">
                                                        <i class="ti-plus"></i>
                                                        Criar uma locação
                                                    </button>-->
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div id="bg-inverse" class="panel-collapse collapse show">
                                                <div class="portlet-body">
                                                    <form class="form-horizontal" id="locacao" role="form">
                                                        <input type="hidden" name="id_cliente" value=""/>
                                                        <input type="hidden" name="id_veiculo" value=""/>
                                                        <input type="hidden" name="id_categoria" value=""/>

                                                        <div class="form-row">
                                                            <label class="col-form-label">CPF/CNPJ</label>
                                                            <div class="input-group">
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
                                                                <select name="veiculos" id="veiculos">
                                                                </select>
                                                            </div>
                                                            <div class="form-group col-md-3">
                                                                <label class="col-form-label">Valor diária</label>
                                                                <input type="text" name="veiculo_valor" autocomplete="off" class="form-control" disabled>
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <label class="col-form-label">Quantidade de Dias</label>
                                                            <div class="input-group">
                                                                <input type="text" name="qtd_dias" class="form-control col-md-3">
                                                                <span class="input-group-append">
                                                                    <button type="button" id="calc" class="btn btn-primary">Calcular Valor</button>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-9"></div>
                                                            <div class="form-group col-md-3">
                                                                <label class="col-form-label">Valor Total</label>
                                                                <input type="text" name="valor_aluguel" autocomplete="off" class="form-control" disabled>
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <label class="col-form-label">Observações</label>
                                                            <textarea class="form-control" id="observacao" rows="5"></textarea>
                                                        </div>
                                                        <div class="form-row ">
                                                            <button type="button" id="cancelar" class="btn btn-secondary waves-effect" data-dismiss="modal">
                                                                Cancelar
                                                            </button>
                                                            <button type="submit" id="enviar" class="btn btn-success waves-effect waves-light">
                                                                Alugar
                                                            </button>
                                                        </div>
                                                    </form>
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
                //dropdownParent: $('#cadastro')
            });
            getVeiculos();
        });

        $("#veiculos").change(function () {
            $("input[name='veiculo_valor']").val($(this).children("option:selected").data('valor'));
            $('input[name="id_veiculo"]').val($(this).children("option:selected").val());
        });

        function getVeiculos() {
            $.ajax({
                url: '../getveiculos',
                type: 'GET',
                success: function (data) {
                    $('#veiculos').empty(); // aqui deixo o select Vazio
                    $('<option>').val(0).text("Selecione o Veículo").appendTo('#veiculos'); // aqui defino a primeira opção para orientar o usuario
                    for (var i in data) {
                        var options = $('<option data-valor="' + data[i].valor + '">').val(data[i].id).text(data[i].modelo);
                        options.appendTo('#veiculos');
                    }
                },
                error: function () {
                    JOptionPane.showMessageDialog('error', 'Cliente inexistente');
                }
            });
        }

        $('#search_client').click(function () {
            if($('#cpf_cnpj').val() === '') {
                JOptionPane.showMessageDialog('warning', 'Digite o CPF');
                return;
            }
            
            $.ajax({
                url: '../cliente/search',
                data: {
                    'cpf': $('#cpf_cnpj').unmask().val()
                },
                type: 'GET',
                success: function (data) {
                    if(data.length === 0) {
                        JOptionPane.showMessageDialog('warning', 'Este Cliente já possui uma locação em aberto!');
                        return;
                    }
                    $('input[name="id_cliente"]').val(data[0].id);
                    $("input[name='nome']").val(data[0].nome);
                    $("input[name='id_categoria']").val(data[0].idCategoriaCliente);
                    $("input[name='cnh']").val(data[0].cnh);
                    $("input[name=validade_cnh]").val(moment(data[0].validadeCnh).format("DD/MM/YYYY"));
                },
                error: function () {
                    JOptionPane.showMessageDialog('error', 'Cliente inexistente');
                }
            });
        });
        
        $('#calc').click(function() {
            if($("input[name='veiculo_valor']").val() === '') {
                JOptionPane.showMessageDialog('warning', 'Selecione um veículo');
                return;
            }
            
            if($("input[name='qtd_dias']").val() === '') {
                JOptionPane.showMessageDialog('warning', 'Selecione a quantidade de dias');
                return;
            }
            
            $.ajax({
               url: '../get-desconto',
               type: 'POST',
               data: {
                   id_categoria: $("input[name='id_categoria']").val(),
                   qtd_dias: $("input[name='qtd_dias']").val(),
                   valor: parseFloat($("input[name='veiculo_valor']").val()) * parseFloat($("input[name='qtd_dias']").val())      
               },
               success: function(result) {
                   $("input[name='valor_aluguel']").val(result.valor);
               }
            });
            
            
        });
        
        $("#locacao").submit(function(event) {
            event.preventDefault();
            if(validaFormulario()) {
                $.ajax({
                url: '../locacao/salvar',
                type: 'POST',
                data: {
                    'id_cliente' : $("input[name='id_cliente']").val(),
                    'id_veiculo' : $("input[name='id_veiculo']").val(),
                    'valor' : $("input[name='valor_aluguel']").val(),
                    'qtd_dias' : $("input[name=qtd_dias]").val(),
                    'id_categoria' : $("input[name='id_categoria']").val(),
                    'obs' : $("#observacao").val()
                },
                success: function (data) {
                    data.return === "success" ? JOptionPane.showMessageDialog('success', 'Locação realizada com sucesso !') : JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao realizar a locação !');
                    $("#cpf_cnpj").val('');
                    $("#input[name='nome']").val('');
                    $("#veiculos").val(0).trigger('change');
                    $("input[name='veiculo_valor']").val('');
                    $("input[name='cnh']").val('');
                    $("input[name='validade_cnh']").val('');
                    $("input[name='veiculo_valor']").val('');
                    $("input[name='qtd_dias']").val('');
                    $("input[name='valor_aluguel']").val('');
                    $("#observacao").val('');

                },
                error: function () {
                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao realizar a locação!');
                }
            });
            }
        });
        
        function validaFormulario()
        {
            if($('#cpf_cnpj').val() === '') {
                JOptionPane.showMessageDialog('warning', 'Digite um valor no campo CPF/CNPJ');
                return false;
            }
            
            if($('#veiculos').val() === '0' || $('#veiculos').val() === 0) {
                JOptionPane.showMessageDialog('warning', 'Selecione um veículo');
                return false;
            }
            
            if($('input[name="qtd_dias"]').val() === '') {
                JOptionPane.showMessageDialog('warning', 'Digite um valor no campo Quantidade de Dias');
                return false;
            }
            
            return true;
        }
        
        

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

    </script>



</body>
</html>