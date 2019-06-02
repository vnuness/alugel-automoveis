$(document).ready(function () {

    $('#filial, #cargo').select2({
        dropdownParent: $('#cadastro')
    });
    loadTable(0);
    popSelectBox();
});
//Essa função é a responsável por carregar a tabela com os dados do Banco de Dados
function loadTable(id)
{
    //Aqui faço uma requisição AJAX para pegar todos os registros.
    $.ajax({
        url: "../lista-funcionarios",
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
                '<td>' + moment(data[i].dataCadastro).format("DD/MM/YYYY hh:mm") + '</td>';
                if(data[i].idStatus === 1) {
                    html += '<td style="text-align: center;"><button onClick="edit(' + data[i].id + ')" type="button" id="editar" class="btn btn-primary btn-sm waves-effect" data-id="' + data[i].id + '">Editar</button> <button type="button" onClick="remove(' + data[i].id + ')" data-id="' + data[i].id + '" id="excluir" class="btn btn-danger btn-sm waves-effect waves-light">Inativar</button></td>'
                + '</tr>'; 
                } else {
                    html += '<td style="text-align: center;"><button onClick="ativar(' + data[i].id + ')" type="button" id="ativar" class="btn btn-success btn-sm waves-effect" data-id="' + data[i].id + '">Ativar</button> </td></tr>'; 
                }
        $('#tbl_usuarios tr').last().after(html);
    }
}

function ativar(id) {
    $.ajax({
       url: '../funcionario/ativar',
       type: 'POST',
       data: {
           'id': id
       },
       success: function(result) {
           if(result.return == 'success') {
               loadTable(0);
               JOptionPane.showMessageDialog('success', 'Usuario ativado com sucesso!');
           } else {
               JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao ativar o usuario!');
           }
       }
    });
}

$('#cadastro').on('hidden.bs.modal', function (e) {
    if ($("#enviar").hasClass("editar")) {
        $("#enviar").removeClass("editar");
        limparFormulario();
    }
});

/*
 * 
 * @type type
 * success, question, warning, error
 *
 */

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
        });
    }
};

//Essa função é responsável por pegar dados quando formos atualizar ou cadastrar.
function pegarDados(action)
{
    if (action === "salvar") {
        console.log($('input[name=matricula]').val());
        return {
            'matricula': $('input[name=matricula]').val(),
            'nome': $('input[name=nome]').val(),
            'email': $('input[name=email]').val(),
            'senha': $('input[name=senha]').val(),
            'filial': $('#filial').val(),
            'cargo': $('#cargo').val()
        };
    } else if (action === "editar") {
        return {
            'id': $('input[name=id]').val(),
            'matricula': $('input[name=matricula]').val(),
            'nome': $('input[name=nome]').val(),
            'email': $('input[name=email]').val(),
            'senha': $('input[name=senha]').val(),
            'filial': $('#filial').val(),
            'cargo': $('#cargo').val()
        };
    }

}

$('#cad-veiculos').submit(function (e) {
    e.preventDefault();
    if ($("#enviar").hasClass("editar")) {
        if (validarFormulario()) {
            $.ajax({
                url: "../funcionario/atualizar",
                type: 'POST',
                data: pegarDados('editar'),
                success: function (result) {
                    if (result.return === "success") {
                        JOptionPane.showMessageDialog('success', 'Usuário atualizado com sucesso!');
                        limparFormulario();
                        $('#enviar').removeClass('editar');
                        $('#cadastro').modal('hide');
                        loadTable(0);
                    } else {
                        JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Usuário!');
                    }
                },
                error: function () {
                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao atualizar o Usuário!');
                }
            });
        }
    } else {
        if (validarFormulario()) {
            $.ajax({
                url: "../funcionario-salvar",
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
        url: "../lista-funcionarios",
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
        title: 'Você tem certeza que deseja inativar este usuário?',
        text: "Você não poderá reverter isso!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Não',
        confirmButtonText: 'Sim'
    }).then((result) = function () {
        $.ajax({
            url: "../funcionario/inativar",
            type: 'POST',
            data: {
                'id': id 
            },
            success: function (data) {
                if (data.return === "success") {
                    swal(
                            'Inativado!',
                            'Usuário inativado com sucesso!.',
                            'success'
                            )
                    loadTable(0); 
                } else {
                    JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao inativar o Usuário!');
                }
            },
            error: function () {
                JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao inativar o Usuário!');
            }
        });
    });

}

function setFields(data)
{
    $('input[name=id]').val(data.id);
    $('input[name=matricula]').val(data.matricula);
    $('input[name=email]').val(data.email);
    $('input[name=nome]').val(data.nome);
    $('#cargo').val(data.cargo).trigger('change');
    $('#filial').val(data.filial).trigger('change');
}

function popSelectBox()
{
    $.ajax({
        url: "../get-cargo",
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
        url: "../get-filial",
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

function isNumber(n)
{
    
    return !isNaN(parseFloat(n)) && isFinite(n);
}