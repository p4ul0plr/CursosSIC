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
import model.bean.Curso;

/**
 *
 * @author paulo
 */
public class CursoDAO {

    public void create(Curso curso) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO T_Curso (nome, descricao, carga_horaria) "
                    + "VALUES(UPPER(?), ?, ?)");

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getCargahoraria());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar curso!");
            throw new RuntimeException("Erro ao inserir no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Curso> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> listaCurso = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM T_Curso");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("pk_cod_curso"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("carga_horaria")
                );
                listaCurso.add(curso);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Cursos!");
            throw new RuntimeException("Erro ao ler no Banco de Dados: ", ex);
        }

        return listaCurso;
    }

    public void update(Curso curso) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE T_Curso SET nome = UPPER(?), descricao = ?, carga_horaria = ? "
                    + "WHERE pk_cod_curso = ?");

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getCargahoraria());
            stmt.setInt(4, curso.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar curso!");
            throw new RuntimeException("Erro ao atualizar no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Curso curso) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM T_Curso WHERE pk_cod_curso = ?");

            stmt.setInt(1, curso.getCod());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Curso!");
            throw new RuntimeException("Erro ao excluir Curso no Banco de Dados: ", ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
