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
            stmt = con.prepareStatement("INSERT INTO (pk_cpf_aluno, "
                    + "nome, "
                    + "email, "
                    + "data_nascimento, "
                    + "ddd, "
                    + "numero,"
                    + "end_rua"
                    + "end_numero"
                    + "end_bairro"
                    + "end_cidade"
                    + "end_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, aluno.getDataNascimento());
            stmt.setInt(5, aluno.getTelDdd());
            stmt.setInt(6, aluno.getTelNumero());
            stmt.setString(7, aluno.getEndRua());
            stmt.setString(8, aluno.getEndBairro());
            stmt.setString(9, aluno.getEndCidade());
            stmt.setString(10, aluno.getEndEstado());
            
            stmt.executeUpdate();
            
            System.out.println("Salvo com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
