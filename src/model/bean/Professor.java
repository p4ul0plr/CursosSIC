/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author paulo
 */
public class Professor extends Pessoa {

    private String formacao;
    private String instituicao;

    public Professor() {
        
    }
    
    public Professor(String cpf, String nome, String formacao, String instituicao, String email, String endRua, Integer endNumero, String endBairro, String endCidade, String endEstado, int telDdd, String telNumero, String dataNascimento, String sexo, String cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.formacao = formacao;
        this.instituicao = instituicao;
        this.email = email;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endBairro = endBairro;
        this.endCidade = endCidade;
        this.endEstado = endEstado;
        this.telDdd = telDdd;
        this.telNumero = telNumero;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endCep = cep;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

}
