package com.weg.olamundo.repository;

import com.weg.olamundo.model.Aluno;
import com.weg.olamundo.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {
    public List<Aluno> obterAlunos()throws SQLException {
        List<Aluno> alunos = new ArrayList<>();

        String query = """
                SELECT id, nome, turma, sala
                FROM aluno
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("turma"),
                        rs.getInt("sala")
                ));
            }
            return alunos;
        }
    }

    public Aluno cadastrar(Aluno aluno) throws SQLException{
    String query = """
            INSERT INTO aluno (nome, turma, sala)
            VALUES (?,?,?)
            """;

    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

        stmt.setString(1, aluno.getNome());
        stmt.setInt(2, aluno.getTurma());
        stmt.setInt(3, aluno.getSala());
        stmt.executeUpdate();

        try(ResultSet rs = stmt.getGeneratedKeys()){
            if(rs.next()){
                aluno.setId(rs.getInt(1));
            }else{
                throw new SQLException("ID não inserido no banco de dados");
            }
        }


    }
    return aluno;
    }

}