package com.weg.olamundo.service;


import com.weg.olamundo.model.Aluno;
import com.weg.olamundo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> obterAlunos() throws SQLException {
        return alunoRepository.obterAlunos();
    }

    public Aluno cadastrar(Aluno aluno) throws SQLException{
       return alunoRepository.cadastrar(aluno);
    }

    public void deletar(int id) throws SQLException{
        alunoRepository.deletar(id);
    }

    public Aluno atualizar (Aluno aluno, int id) throws SQLException{
         return alunoRepository.atualizar(aluno, id);
    }

}






