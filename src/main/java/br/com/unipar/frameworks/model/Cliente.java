package br.com.unipar.frameworks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;
    
    @Column(length = 120)
    private String nome;
    
    @Column(unique = true)
    private String cpf;
    
    private String email;
    private Boolean ativo = true;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, 
            orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pet> pets;

    public Cliente() { }
    
    public Cliente(String nome, String cpf, String email, Boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.ativo = ativo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + 
                ", nome=" + nome + 
                ", cpf=" + cpf + 
                ", email=" + email + 
                ", ativo=" + ativo + 
                ", enderecos=" + enderecos + 
                ", pets=" + pets + '}';
    }
    
    
    
    
}
