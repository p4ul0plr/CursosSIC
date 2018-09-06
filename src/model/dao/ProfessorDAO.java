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
import model.bean.Professor;

/**
 *
 * @author paulo
 */
public class ProfessorDAO {

    public void create(Professor professor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO T_Professor(pk_cpf_prof, "
                    + "nome, "
                    + "formacao ,"
                    + "instituicao, "
                    + "email, "
                    + "end_rua, "
                    + "end_numero, "
                    + "end_bairro, "
                    + "end_cidade, "
                    + "end_estado, "
                    + "ddd, "
                    + "numero, "
                    + "data_nascimento, "
                    + "sexo, "
                    + "end_cep) VALUES(?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), ?, UPPER(?), UPPER(?), ?, ?, ?, CONVERT(?, DATE), ?, ?)");

            stmt.setString(1, professor.getCpf());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getFormacao());
            stmt.setString(4, professor.getInstituicao());
            stmt.setString(5, professor.getEmail());
            stmt.setString(6, professor.getEndRua());
            stmt.setInt(7, professor.getEndNumero());
            stmt.setString(8, professor.getEndBairro());
            stmt.setString(9, professor.getEndCidade());
            stmt.setString(10, professor.getEndEstado());
            stmt.setInt(11, professor.getTelDdd());
            stmt.setString(12, professor.getTelNumero());
            stmt.setString(13, professor.getDataNascimento());
            stmt.setString(14, professor.getSexo());
            stmt.setString(15, professor.getEndCep());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Professor!");
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Professor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> listaProfessor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM T_Professor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getString("pk_cpf_prof"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("formacao"),
                        rs.getString("instituicao"),
                        rs.getString("end_rua"),
                        rs.getInt("end_numero"),
                        rs.getString("end_bairro"),
                        rs.getString("end_cidade"),
                        rs.getString("end_estado"),
                        rs.getInt("ddd"),
                        rs.getString("numero"),
                        rs.getString("data_nascimento"),
                        rs.getString("sexo"),
                        rs.getString("end_cep")
                );
                listaProfessor.add(professor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler cadastro!");
            throw new RuntimeException("Erro ao ler no Banco de Dados: ", ex);
        }

        return listaProfessor;
    }

    public void update(Professor professor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE T_Professor SET nome = UPPER(?), "
                    + "formacao = UPPER(?), "
                    + "instituicao = UPPER(?), "
                    + "email = UPPER(?), "
                    + "end_rua = UPPER(?), "
                    + "end_numero = ?, "
                    + "end_bairro = UPPER(?), "
                    + "end_cidade = UPPER(?), "
                    + "end_estado = ?, "
                    + "ddd = ?, "
                    + "numero = ?, "
                    + "data_nascimento = ?, "
                    + "sexo = ?, "
                    + "end_cep = ? "
                    + "WHERE pk_cpf_prof = ?");

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getFormacao());
            stmt.setString(3, professor.getInstituicao());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.getEndRua());
            stmt.setInt(6, professor.getEndNumero());
            stmt.setString(7, professor.getEndBairro());
            stmt.setString(8, professor.getEndCidade());
            stmt.setString(9, professor.getEndEstado());
            stmt.setInt(10, professor.getTelDdd());
            stmt.setString(11, professor.getTelNumero());
            stmt.setString(12, professor.getDataNascimento());
            stmt.setString(13, professor.getSexo());
            stmt.setString(14, professor.getEndCep());
            stmt.setString(15, professor.getCpf());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizado cadastro!");
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
        public void delete(Professor professor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM T_Professor WHERE pk_cpf_prof = ?");

            stmt.setString(1, professor.getCpf());

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
