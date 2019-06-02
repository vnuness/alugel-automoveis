/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author oem
 */
public class MotoristaAplicativo extends PessoaFisica {

    public MotoristaAplicativo(int cId, String cNome, String cCpfCnpj, int cIdsexo, String cCnh, int cIdcategoriacnh, String cRg, String cEmail, String cNacionalidade, String cDatanascimento, String cEndereco, String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular, int cStatus, int cIdCategoriaCliente, String validadeCnh, int cNumero) {
        super(cId, cNome, cCpfCnpj, cIdsexo, cCnh, cIdcategoriacnh, cRg, cEmail, cNacionalidade, cDatanascimento, cEndereco, cCep, cBairro, cComplemento, cCidade, cEstado, cCelular, cStatus, cIdCategoriaCliente, validadeCnh, cNumero);
    }
    
    public MotoristaAplicativo(String cNome, String cCpfCnpj, int cIdsexo, int cIdCategoriaCliente, String cCnh, int cIdcategoriacnh,
            String cRg, String cEmail, String cNacionalidade, String cDatanascimento, String cValidadeCnh, String cCep, String cEndereco, int cNumero,
            String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular
            ) {
        super(cNome, cCpfCnpj, cIdsexo, cIdCategoriaCliente, cCnh, cIdcategoriacnh, cRg, cEmail, cNacionalidade, cDatanascimento, cValidadeCnh, cCep, cEndereco, cNumero, cBairro, cComplemento, cCidade, cEstado, cCelular);
    }
    
    public MotoristaAplicativo() {
        
    }
    
    @Override
    public double aplicaDesconto(double valor, int qtdDias) {
        double desconto;
        double valorAtualizado;
        if (qtdDias >= 7) {
            desconto = (valor * 15) / 100;
            valorAtualizado = valor - desconto;
        } else {
            valorAtualizado = valor;
        }

        return valorAtualizado;
    }
}
