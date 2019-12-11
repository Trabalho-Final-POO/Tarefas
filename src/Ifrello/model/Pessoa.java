package Ifrello.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//GUSTAVO MARTINS PACHECO       HT3000231
//LAÍS JAQUELINE DA SILVA LOPES HT3000168


@Entity
public class Pessoa implements Serializable{
    
    @Id
    private long cpf;
    private String nome;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();

    public Pessoa() {
    }
    
    public Pessoa(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Pessoa(long cpf, String nome, List<Tarefa> tarefas) {
        this.cpf = cpf;
        this.nome = nome;
        this.tarefas = tarefas;
    }

    
    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
    
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf = " + cpf + ", nome = " + nome + ", tarefas = " + tarefas + '}';
    }

}
