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
public class Turma {

    private int cod;
    private String nome;
    private String horaio;
    private String dataInicial;
    private String dataFinal;
    private int quantidadeVagas;

    public Turma(int cod, String nome, String horaio, String dataInicial, String dataFinal, int quantidadevagas) {
        this.cod = cod;
        this.nome = nome;
        this.horaio = horaio;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.quantidadeVagas = quantidadevagas;
    }

    public Turma(String nome, String horaio, String dataInicial, String dataFinal, int quantidadeVagas) {
        this.nome = nome;
        this.horaio = horaio;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.quantidadeVagas = quantidadeVagas;
    }

    public Turma() {

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
    
    public String getHoraio() {
        return horaio;
    }

    public void setHoraio(String horaio) {
        this.horaio = horaio;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadevagas) {
        this.quantidadeVagas = quantidadevagas;
    }

}
