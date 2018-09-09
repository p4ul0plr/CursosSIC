/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class Aluno extends Pessoa {

    private List<Turma> turmasMatriculadas = new ArrayList<>();

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

    public void efetuarMatricula(Turma turma) {
        this.getTurmasMatriculadas().add(turma);
    }

    public boolean estaMatriculado() {
        return !this.getTurmasMatriculadas().isEmpty();
    }

    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }

    public void setTurmasMatriculadas(List<Turma> turmasMatriculadas) {
        this.turmasMatriculadas = turmasMatriculadas;
    }

}
