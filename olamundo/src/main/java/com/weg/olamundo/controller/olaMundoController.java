package com.weg.olamundo.controller;

import com.weg.olamundo.model.Aluno;
import com.weg.olamundo.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import com.weg.olamundo.repository.AlunoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class olaMundoController {

    private final AlunoService alunoService;

    public olaMundoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }
    @GetMapping
       public List<Aluno> alunos() throws SQLException{
        List<Aluno> alunos = new ArrayList<>();
         try{
             alunos = alunoService.obterAlunos();
         }catch (SQLException e){
             e.printStackTrace();
         }
         return alunos;
    }

    @PostMapping
    public Aluno postAluno( @RequestBody Aluno aluno) throws SQLException{
           return alunoService.cadastrar(aluno);

    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable int id) throws SQLException{
        alunoService.deletar(id);
    }

    @PutMapping("/{id}")
    public Aluno putAluno(@RequestBody Aluno aluno, @PathVariable int id) throws SQLException{
         return alunoService.atualizar(aluno, id);
    }


}
