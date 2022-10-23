package com.example.trabalho1.customAdapter;
import android.text.Editable;
public class profissional {
    public profissional(String nome, String profissao, boolean empregado, String experiencia) {
        this.nome = nome;
        this.profissao = profissao;
        this.empregado = empregado;
        Experiencia = experiencia;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    public boolean isEmpregado() {
        return empregado;
    }
    public void setEmpregado(boolean empregado) {
        this.empregado = empregado;
    }
    public String getExperiencia() {
        return Experiencia;
    }
    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }
    private String nome;
    private String profissao;
    private boolean empregado;
    private String Experiencia;
}