package br.com.unipar.frameworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //declara que é uma entidade persistente
public class Usuario {
    
    @Id //declara que esse atributo é a PK
    @GeneratedValue(strategy = GenerationType.AUTO) //gera da forma que achar melhor
    @Column(name = "id") //declara coluna com restrições (no caso o nome)
    private Long idUsuario;
    
    @Column(length = 20, nullable = false) //declara coluna com tamanho e not null
    private String nome;
    
    @Column(length = 10, nullable = false) //declara coluna com tamanho e not null
    private String senha;
    
    private Boolean ativo = true; // não tem anotação declara que é coluna persistente

    public Usuario() {
    }

    public Usuario(String nome, String senha, Boolean ativo) {
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }
    
    

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

  
}
