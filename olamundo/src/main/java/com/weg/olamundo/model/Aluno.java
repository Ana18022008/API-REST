package com.weg.olamundo.model;

public class Aluno {

    private int id;
    private String nome = "";
    private int turma;
    private int sala;

    public Aluno() {

    }

    public Aluno(String nome, int turma, int sala) {
        this.nome = nome;
        this.turma = turma;
        this.sala = sala;
    }

    public Aluno(int id, String nome, int turma, int sala) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }


}
