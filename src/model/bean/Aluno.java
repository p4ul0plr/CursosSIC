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
public class Aluno extends Pessoa {

    public Aluno() {
        
    }
    
    public Aluno(String cpf, String nome, String email, String dataNascimento, String endRua, Integer endNumero, String endBairro, String endCidade, String endEstado, int telDdd, String telNumero, String sexo, String cep) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endBairro = endBairro;
        this.endCidade = endCidade;
        this.endEstado = endEstado;
        this.telDdd = telDdd;
        this.telNumero = telNumero;
        this.sexo = sexo;
        this.endCep = cep;
    }
    
    

}
