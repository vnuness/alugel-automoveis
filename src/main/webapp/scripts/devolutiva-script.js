var isValidated = false;

$(document).ready(function () {

    $('#avaliacao').select2();

});
$('#cpf_cnpj').focusout(function () {
    $.ajax({
        'url': '../devolutiva/buscar-cliente',
        'type': 'POST',
        'data': {
            'cpf': $('#cpf_cnpj').val()
        },
        success: function (data) {
            if (data.length !== 0) {
                isValidated = true;
                $('#id_cliente').val(data[0].idCliente);
                $('#id_locacao').val(data[0].idLocacao);
            } else {
                JOptionPane.showMessageDialog('warning', 'Este cliente não possui locação em aberto. Digite outro CPF!');
                return;
            }
        },
        error: function () {
            JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao buscar o cliente!');
        }
    });
});
$('#salvar').click(function () {
    if (!isValidated) {
        JOptionPane.showMessageDialog('warning', 'Digite um CPF ou CNPJ válido!');
        return;
    }
    if (validarFormulario()) {
        $.ajax({
            'url': '../devolutiva/salvar',
            'type': 'POST',
            'data': {
                'id_cliente': $('#id_cliente').val(),
                'id_avaliacao': $('#avaliacao').val(),
                'id_tipo_devolutiva': $('input[name=categoria_devolutiva]:checked').val(),
                'id_locacao': $('#id_locacao').val(),
                'observacao': $('#observacao').val()
            },
            success: function () {

                JOptionPane.showMessageDialog('success', 'Devolutiva realizada com sucesso!');
                $('#cpf_cnpj').val('');
                $('#avaliacao').val(0).trigger('change');
                $('#observacao').val('');
                $('#id_locacao').val('');

            },
            error: function () {
                JOptionPane.showMessageDialog('error', 'Ocorreu um erro ao realizar a devolutiva!');
            }
        });
    }
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
};

function validarFormulario() {
    if ($('#avaliacao').val() === 0 || $('#avaliacao').val() == '') {
        JOptionPane.showMessageDialog('warning', 'Selecione a avaliação do cliente');
        return false;
    }

    if ($('#cpf_cnpj').val() === '') {
        JOptionPane.showMessageDialog('warning', 'Selecione o CPF ou CNPJ do cliente');
        return false;
    }

    return true;
}