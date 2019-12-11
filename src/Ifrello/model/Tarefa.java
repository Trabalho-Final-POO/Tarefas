package Ifrello.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//GUSTAVO MARTINS PACHECO       HT3000231
//LAÍS JAQUELINE DA SILVA LOPES HT3000168


@Entity
public class Tarefa implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;

    public Tarefa() {
    }

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public Tarefa(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

    @Override
    public String toString() {
        return "Tarefa: {" + "id = " + id + ", descrição = " + descricao + '}';
    }
    
    
    
}
