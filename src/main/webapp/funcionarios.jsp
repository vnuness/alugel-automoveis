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
            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <script>
            var resizefunc = [];        </script>

        <script>
                    $(document).ready(function () {
            //Tudo o que estiver aqui dentro, é carregado ao iniciar a página. É como a função "InitComponents" do JAVA SWING
            $('#filial, #cargo').select2({
            dropdownParent: $('#cadastro')
            });
                    $('input[name=placa]').mask('AAA-0000');
                    loadTable(0);
    popSelectBox();
            });
                    //Essa função é a responsável por carregar a tabela com os dados do Banco de Dados
                            function loadTable(id)
                            {
                            //Aqui faço uma requisição AJAX para pegar todos os registros.
                            $.ajax({
                            url: "lista-funcionarios",
                                    type: 'GET',
                                    data: {
                                    'id': id //aqui passo um ID que veio por parametro na funcao. Se o id for ZERO, trará todos os registros. Caso o ID seja outro, trará somente os dados daquele id especifico.
                                    },
                                    success: function (result) {
                                    popTable(result); // Aqui chamo uma função que preenche a tabela com os dados. passo por parâmetro os dados que vieram da consulta em formato JSON.
                                            return result;
                                    },
                                    error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                                    }
                            });
                            }

                    //Essa função preenche a tabela com os dados que são passados por parâmetro em formato JSON
                    function popTable(data)
                    {
                    console.log(data);
                            $('#tbl_usuarios tr').not(':first').remove(); //Aqui eu limpo a tabela
                            var html = '';
                            for (var i in data) {
                    html = '<tr><td>' + data[i].id + '</td>' +
                            '<td>' + data[i].matricula + '</td>' +
                            '<td>' + data[i].email + '</td>' +
                            '<td>' + data[i].nome + '</td>' +
                            '<td>' + data[i].cargo + '</td>' +
                            '<td>' + data[i].filial + '</td>' +
                            '<td>' + moment(data[i].dataCadastro).format("DD/MM/YYYY hh:mm") + '</td>' +
                            '<td><button onClick="edit(' + data[i].id + ')" type="button" id="editar" class="btn btn-primary btn-sm waves-effect" data-id="' + data[i].id + '">Editar</button> <button type="button" onClick="remove(' + data[i].id + ')" data-id="' + data[i].id + '" id="excluir" class="btn btn-danger btn-sm waves-effect waves-light">Inativar</button></td>'
                            + '</tr>'; // Aqui crio os dois botões de ação. Repare que há o parâmetro onClick. Dentro do onClick, chamo uma função e passo um ID. Ou seja, qualquer ação do botão, irá referenciar o ID (veiculo) de sua respectiva linha
                            $('#tbl_usuarios tr').last().after(html); // AQUI insiro o registro na última linha da tabela
                    }
                    }
                    /*
                     * 
                     * @type type
                     * success, question, warning, error
                     */
                    //Aqui é um Objeto que dentro possui um método. Criei dessa forma para ficar parecido com o que usávamos no JAVA SWING
                    //É necessário passar dois parametros para a funcao. Type e Message. Type definirá o tipo do POP UP. e Message, definirá a Mensagem que será exibida no PopUP
                    let me = this;
                            $('#cadastro').on('hidden.bs.modal', function (e) {
                    if ($("#enviar").hasClass("editar")) {
                    $("#enviar").removeClass("editar");
                            me.limparFormulario();
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
                            }

                    //Essa função é responsável por pegar dados quando formos atualizar ou cadastrar.
                    function pegarDados(action)
                    {
                    if (action === "salvar") { // se a ação for salvar, não passo ID
                    return {
                    'matricula': $('input[name=matricula]').val(),
                            'nome': $('input[name=nome]').val(),
                            'email': $('input[name=email]').val(),
                            'senha': $('input[name=senha]').val(),
                            'filial': $('#filial').val(),
                            'cargo' : $('#cargo').val()
                    }
                    } else if (action === "editar") { // se a ação for Editar, passo o ID para editar somente aquele ID.
                    return {
                    'id': $('input[name=id]').val(),
                            'matricula': $('input[name=matricula]').val(),
                            'nome': $('input[name=nome]').val(),
                            'email': $('input[name=email]').val(),
                            'senha': $('input[name=senha]').val(),
                            'filial': $('#filial').val(),
                            'cargo' : $('#cargo').val()
                    }
                    }

                    }

                    $('#cad-veiculos').submit(function (e) { // AQUI criei uma função para quando o usuário preencher o formulário de cadastro (ou edição)
                    e.preventDefault();
                            if ($("#enviar").hasClass("editar")) { //AQUI eu verifico se o botão Enviar, possui a classe "editar" Caso sim, o usuário esta tentando editar um registro
                    if (validarFormulario()) {
                    $.ajax({
                    url: "veiculos",
                            type: 'POST',
                            data: pegarDados('editar'), // aqui passo por parametro a ação que estou realizando. Ou seja, estou passando o ID
                            success: function (result) {
                            //sempre que cadastramos ou editamos, o SERVLET nos retorna sucesso ou erro. Aqui verifico se o retorno foi sucesso
                            if (result.return === "success") {
                            JOptionPane.showMessageDialog('success', 'Produto atualizado com sucesso!'); // Exibo mensagem de sucesso
                                    limparFormulario(); // Limpo o Formulário
                                    $('#enviar').removeClass('editar'); // Aqui, removo a classe editar. Para que o Botão volte a sua caracteristica padrão, que é cadastrar.
                                    $('#cadastro').modal('hide'); // Aqui oculto o formulário de cadastro
                                    loadTable(0); // Carrego a tabela novamente com todos os registros
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
                    url: "funcionario-salvar",
                            type: 'POST',
                            data: pegarDados('salvar'),
                            success: function (result) {
                            console.log(result.return);
                                    if (result.return === "success") {
                            JOptionPane.showMessageDialog('success', 'Usuário cadastrado com sucesso!');
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
                            //Esta função é responsável por Carregar o formulário com os dados do item selecionado, para ser editado. Ela é acionada ao clicar no botao editar
                                    function edit(id) {
                                    $('input[name="matricula"]').removeAttr("required", "required");
                                            $('#row-matricula').hide();
                                            $.ajax({
                                            url: "lista-funcionarios",
                                                    type: 'GET',
                                                    data: {
                                                    'id': id
                                                    },
                                                    success: function (result) {
                                                    //Aqui faço um for each com o que veio do Servlet
                                                    for (var i in result) {
                                                    setFields(result[i]); // passo os itens do registro por parametro para essa funcao
                                                    }
                                                    $('#enviar').addClass("editar"); // aqui adiciono a classe editar no botao, para que o SERVLET entenda que estou editando
                                                            $('#cadastro').modal('show'); // aqui exibo o pop up de cadastro com os campos preenchidos
                                                    },
                                                    error: function () {
                                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar a Tabela!');
                                                    }
                                            });
                                    }
                            //Essa função exclui o produto. É acionada ao clicar sobre o botão excluir
                            function remove(id)
                            {
                            swal({
                            title: 'Você tem certeza que deseja inativar este usuário?',
                                    text: "Você não poderá reverter isso!",
                                    type: 'warning',
                                    showCancelButton: true,
                                    confirmButtonColor: '#3085d6',
                                    cancelButtonColor: '#d33',
                                    cancelButtonText: 'Não',
                                    confirmButtonText: 'Sim'
                            }).then((result) => {
                            $.ajax({
                                    url: "funcionario/inativar",
                                    type: 'POST',
                                    data: {
                                    'id': id // aqui passo os parametros para o Servlet. 
                                    },
                                    success: function (data) {
                                    if (data.return === "success") {
                                    swal(
                                            'Inativado!',
                                            'Usuário inativado com sucesso!.',
                                            'success'
                                            )
                                            loadTable(0); // aqui carrego a tabela após a exclusão
                                    } else {
                                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao inativar o Usuário!');
                                    }
                                    },
                                    error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao inativar o Usuário!');
                                    }
                            });
                            })

                            }
                            //Nessa função, seto o valor dos campos do formulario com o registro que foi passado por parametro. Graças a essa funcão, que os campos estão preenchidos quando o usuario vai editar
                            function setFields(data)
                            {
                            $('input[name=id]').val(data.id);
                                    $('input[name=matricula]').val(data.matricula);
                                    $('input[name=email]').val(data.email);
                                    $('input[name=nome]').val(data.nome);
                                    $('#cargo').val(data.cargo).trigger('change');
                                    $('#filial').val(data.filial).trigger('change');
//                $('#status').val(data.status).trigger('change');
//                $('#combustivel').val(data.combustivel).trigger('change');
//                $('#cambio').val(data.cambio).trigger('change');
//                $('#acessorios').val(data.acessorio);
                            }

                            //Essa função é responsável por preencher com COMBOBOX com os registros do banco de dados.
                            //OU SEJA, os comboBOX não estão com opções SETADAS no HTML. Essas opções vem do banco de dados. LOGO, para adicionar uma nova opção, basta adicionar um registro no banco, na tabala referente ao combo
                            function popSelectBox()
                            {
                            $.ajax({
                            url: "get-cargo",
                                    type: 'GET',
                                    success: function (data) {
                                    $('#cargo').empty();
                                            $('<option>').val(0).text("Selecione o Cargo do usuário").appendTo('#cargo');
                                            for (var i in data) {
                                    var options = $('<option>').val(data[i].id).text(data[i].cargo);
                                            options.appendTo('#cargo');
                                    }
                                    },
                                    error: function () {
                                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os Status dos Veículos!');
                                    }
                            });
                                    $.ajax({
                                    url: "get-filial",
                                            type: 'GET',
                                            success: function (data) {
                                            $('#filial').empty();
                                                    $('<option>').val(0).text("Selecione a Filial do Usuário").appendTo('#filial');
                                                    for (var i in data) {
                                            var options = $('<option>').val(data[i].id).text(data[i].filial);
                                                    options.appendTo('#filial');
                                            }
                                            },
                                            error: function () {
                                            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao carregar os tipos de Combustíveis dos Veículos!');
                                            }
                                    });
                            }

                            //Essa função valida o formulário.
                            //Repare que ela é bem parecida com a forma que usamos no JAVA SWING
                            function validarFormulario()
                            {
                            if ($("#cargo").val() == "0") {
                            JOptionPane.showMessageDialog('warning', 'Selecione um valor no campo Status!');
                                    return false;
                            }
                            if ($("#filial").val() == "0") {
                            JOptionPane.showMessageDialog('warning', 'Selecione um valor no campo Câmbio');
                                    return false;
                            }

                            return true;
                            }
                            //Essa função limpa o formulário. Define os valores dos campos como vazio
                            function limparFormulario()
                            {
                            $('input[name=modelo]').val('');
                                    $('input[name=montadora]').val('');
                                    $('input[name=ano]').val('');
                                    $('input[name=placa]').val('');
                                    $('input[name=renavam]').val('');
                                    $('#status').val('0').trigger('change');
                                    $('#combustivel').val('0').trigger('change');
                                    $('#cambio').val('0').trigger('change');
                                    $('#acessorios').val('');
                            }
                            //Essa função verifica se um valor é numerico
                            function isNumber(n)
                            {
                            //OBS para o grupo: parseInt() não é uma maneira correta de verificar se um número é inteiro em JavaScript, por isso, a validação é feita como abaixo
                            return !isNaN(parseFloat(n)) && isFinite(n);
                            }


        </script>

        <!-- Plugins  -->

    </body>
</html>