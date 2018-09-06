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
public class Curso {

    private int cod;
    private String nome;
    private String descricao;
    private int cargahoraria;

    public Curso(String nome, String descricao, int cargahoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.cargahoraria = cargahoraria;
    }

    public Curso(int cod, String nome, String descricao, int cargahoraria) {
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
        this.cargahoraria = cargahoraria;
    }

    public Curso() {
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

}
