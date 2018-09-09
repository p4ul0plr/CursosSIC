/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Turma;

/**
 *
 * @author paulo
 */
public class TurmaDAO {

    public void create(Turma turma) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO T_Turma (nome, "
                    + "horario, "
                    + "data_inicial, "
                    + "data_final, "
                    + "quantidade_vagas) "
                    + "VALUES(UPPER(?), CONVERT(?, TIME), CONVERT(?, DATE), CONVERT(?, DATE), ?)");

            stmt.setString(1, turma.getNome());
            stmt.setString(2, turma.getHoraio());
            stmt.setString(3, turma.getDataInicial());
            stmt.setString(4, turma.getDataFinal());
            stmt.setInt(5, turma.getQuantidadeVagas());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Turma cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Turma!");
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Turma> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Turma> listaTurma = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM T_Turma");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Turma turma = new Turma(
                        rs.getInt("pk_cod_turma"),
                        rs.getString("nome"),
                        rs.getString("horario"),
                        rs.getString("data_inicial"),
                        rs.getString("data_final"),
                        rs.getInt("quantidade_vagas")
                );
                listaTurma.add(turma);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Turma!");
            throw new RuntimeException("Erro ao ler no Banco de Dados: ", ex);
        }

        return listaTurma;
    }

    public void update(Turma turma) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE T_Turma SET nome = UPPER(?), "
                    + "horario = CONVERT(?, TIME), "
                    + "data_inicial = CONVERT(?, DATE), "
                    + "data_final = CONVERT(?, DATE), "
                    + "quantidade_vagas = ? "
                    + "WHERE pk_cod_turma = ?");

            stmt.setString(1, turma.getNome());
            stmt.setString(2, turma.getHoraio());
            stmt.setString(3, turma.getDataInicial());
            stmt.setString(4, turma.getDataFinal());
            stmt.setInt(5, turma.getQuantidadeVagas());
            stmt.setInt(6, turma.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar turma!");
            throw new RuntimeException("Erro ao atualizar no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Turma turma) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM T_Turma WHERE pk_cod_turma = ?");

            stmt.setInt(1, turma.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Turma excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Turma!");
            throw new RuntimeException("Erro ao excluir Turma no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Turma> readTurmasAluno(Aluno aluno) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Turma> listaTurma = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM T_Turma "
                    + "INNER JOIN R_Aluno_Turma "
                    + "ON T_Turma.pk_cod_turma = R_Aluno_Turma.pk_fk_cod_turma "
                    + "WHERE R_Aluno_Turma.pk_fk_cpf_aluno = ?");
            stmt.setString(1, aluno.getCpf());
            rs = stmt.executeQuery();

            while (rs.next()) {
                Turma turma = new Turma(
                        rs.getInt("pk_cod_turma"),
                        rs.getString("nome"),
                        rs.getString("horario"),
                        rs.getString("data_inicial"),
                        rs.getString("data_final"),
                        rs.getInt("quantidade_vagas")
                );
                listaTurma.add(turma);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Turma!");
            throw new RuntimeException("Erro ao ler no Banco de Dados: ", ex);
        }

        return listaTurma;
    }

}
