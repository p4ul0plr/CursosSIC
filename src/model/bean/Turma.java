/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author paulo
 */
public class Turma {
    
    private int cod;
    private Time horaio;
    private Date dataInicial;
    private Date dataFinal;
    private int quantidadevagas;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Time getHoraio() {
        return horaio;
    }

    public void setHoraio(Time horaio) {
        this.horaio = horaio;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getQuantidadevagas() {
        return quantidadevagas;
    }

    public void setQuantidadevagas(int quantidadevagas) {
        this.quantidadevagas = quantidadevagas;
    }
    
    
    
}
