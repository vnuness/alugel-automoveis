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
                    'numero': $('input[name=numero_pj]').val(),
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