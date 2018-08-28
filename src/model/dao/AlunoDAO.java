/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                    + "end_rua, end_numero, "
                    + "end_bairro, end_cidade, "
                    + "end_estado, "
                    + "ddd, "
                    + "numero, "
                    + "sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
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

            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
