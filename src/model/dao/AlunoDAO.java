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

/**
 *
 * @author paulo
 */
public class AlunoDAO {

    public void create(Aluno aluno) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO T_Aluno(pk_cpf_aluno, "
                    + "nome, "
                    + "email, "
                    + "data_nascimento, "
                    + "end_rua, "
                    + "end_numero, "
                    + "end_bairro, "
                    + "end_cidade, "
                    + "end_estado, "
                    + "ddd, "
                    + "numero, "
                    + "sexo, "
                    + "end_cep) VALUES(?, UPPER(?), UPPER(?), ?, UPPER(?), ?, UPPER(?), UPPER(?), ?, ?, ?, ?, ?)");

            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getDataNascimento());
            stmt.setString(5, aluno.getEndRua());
            stmt.setInt(6, aluno.getEndNumero());
            stmt.setString(7, aluno.getEndBairro());
            stmt.setString(8, aluno.getEndCidade());
            stmt.setString(9, aluno.getEndEstado());
            stmt.setInt(10, aluno.getTelDdd());
            stmt.setString(11, aluno.getTelNumero());
            stmt.setString(12, aluno.getSexo());
            stmt.setString(13, aluno.getEndCep());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar cadastro!");
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Aluno> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> listaAluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM T_Aluno");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("pk_cpf_aluno"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("data_nascimento"),
                        rs.getString("end_rua"),
                        rs.getInt("end_numero"),
                        rs.getString("end_bairro"),
                        rs.getString("end_cidade"),
                        rs.getString("end_estado"),
                        rs.getInt("ddd"),
                        rs.getString("numero"),
                        rs.getString("sexo"),
                        rs.getString("end_cep")
                );
                listaAluno.add(aluno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler cadastro!");
            throw new RuntimeException("Erro ao ler no Banco de Dados: ", ex);
        }

        return listaAluno;
    }

    public void update(Aluno aluno) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE T_Aluno SET nome = UPPER(?), "
                    + "email = UPPER(?), "
                    + "data_nascimento = ?, "
                    + "end_rua = UPPER(?), "
                    + "end_numero = ?, "
                    + "end_bairro = UPPER(?), "
                    + "end_cidade = UPPER(?), "
                    + "end_estado = ?, "
                    + "ddd = ?, "
                    + "numero = ?, "
                    + "sexo = ?, "
                    + "end_cep = ? "
                    + "WHERE pk_cpf_aluno = ?");

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getDataNascimento());
            stmt.setString(4, aluno.getEndRua());
            stmt.setInt(5, aluno.getEndNumero());
            stmt.setString(6, aluno.getEndBairro());
            stmt.setString(7, aluno.getEndCidade());
            stmt.setString(8, aluno.getEndEstado());
            stmt.setInt(9, aluno.getTelDdd());
            stmt.setString(10, aluno.getTelNumero());
            stmt.setString(11, aluno.getSexo());
            stmt.setString(12, aluno.getEndCep());
            stmt.setString(13, aluno.getCpf());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizado cadastro!");
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Aluno aluno) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM T_Aluno WHERE pk_cpf_aluno = ?");

            stmt.setString(1, aluno.getCpf());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cadastro!");
            throw new RuntimeException("Erro ao excluir cadastro no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
