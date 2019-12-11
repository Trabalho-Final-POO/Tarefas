package Ifrello.infra;

import Ifrello.model.Pessoa;
import Ifrello.model.Tarefa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

//GUSTAVO MARTINS PACHECO       HT3000231
//LAÍS JAQUELINE DA SILVA LOPES HT3000168


public class PessoaDAO {

    public void salvar(Pessoa pessoa) {

        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();

        try {
            //abrir uma transacao
            em.getTransaction().begin();
            //solicita ao gerenciador que salve a entidade

            em.persist(pessoa);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }

    public Pessoa recuperaByCPF(long cpf) {
        Pessoa pessoa = new Pessoa();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            
            //solicita ao gerenciador todas a instância da classe Pessoa dado um cpf
            Query query = em.createQuery("from Pessoa p JOIN FETCH p.tarefas where p.cpf = :cpf")
                    .setParameter("cpf", cpf);
            
            pessoa = (Pessoa) query.getSingleResult();
            
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pessoa;
    }
    
    public List<Pessoa> recuperarTodasAsPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            //solicita ao gerenciador todas as instâncias da classe Pessoa
            Query query = em.createQuery("SELECT DISTINCT p from Pessoa p JOIN FETCH p.tarefas");
            pessoas = query.getResultList();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return pessoas;
    }
    
     public List<Tarefa> recuperarTodasAsTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            //solicita ao gerenciador todas as instâncias da classe Tarefa
            Query query = em.createQuery("from Tarefa");
            tarefas = query.getResultList();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return tarefas;
    }
}
