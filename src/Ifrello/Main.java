package Ifrello;


import Ifrello.model.Pessoa;
import Ifrello.model.Tarefa;
import Ifrello.infra.PessoaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//GUSTAVO MARTINS PACHECO       HT3000231
//LAÍS JAQUELINE DA SILVA LOPES HT3000168


public class Main {

    public static void main(String[] args) {
        
        int opcao = 0;
        Scanner leitura = new Scanner(System.in);
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        menuPrincipal(opcao, leitura, pessoaDAO);
    }

    private static void menuPrincipal(int opcao, Scanner leitura, PessoaDAO pessoaDAO) {
        while(opcao != 5){
            
            System.out.println("Bem-vindo ao Ifrello!\n\n");
            System.out.println("1 - Cadastrar pessoa e tarefas\n");
            System.out.println("2 - Listar todas as pessoas\n");
            System.out.println("3 - Listar todas as tarefas\n");
            System.out.println("4 - Consultar uma pessoa pelo CPF\n");
            System.out.println("5 - Sair\n\n");
            System.out.println("Digite uma opção: ");
            
            opcao = leitura.nextInt();
            
            switch(opcao){
                
                case 1:
                    Pessoa pessoaAuxiliar = lerPessoa(leitura);
                    List<Tarefa> listaTarefas = lerTarefas(leitura);
                    
                    pessoaAuxiliar.setTarefas(listaTarefas);
                    pessoaDAO.salvar(pessoaAuxiliar);
                    break;
                case 2:
                    List<Pessoa> pessoas = pessoaDAO.recuperarTodasAsPessoas();
                    pessoas.forEach((p) -> {
                        System.out.println(p.toString());
                    });
                    break;
                case 3:
                    List<Tarefa> tarefas = pessoaDAO.recuperarTodasAsTarefas();
                    tarefas.forEach((t) -> {
                        System.out.println(t.toString());
                    });
                    break;
                case 4:
                    System.out.println("\nDigite o CPF da pessoa para consultá-la: \n");
                    long cpf = leitura.nextLong();
                    System.out.println(pessoaDAO.recuperaByCPF(cpf).toString());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
                    
            }
        }
    }

    private static List<Tarefa> lerTarefas(Scanner leitura) {
        
        int opcao = 0;
        List<Tarefa> listaTarefas = new ArrayList<>();
        
        while(opcao != 2){
            
            System.out.println("\nDigite a descrição da tarefa: \n");
            String descricao = leitura.next();
            Tarefa tarefa = new Tarefa(descricao);
            listaTarefas.add(tarefa);
            System.out.println("\nDeseja cadastrar outra tarefa? 1- Sim / 2 - Não: \n");
            leitura.nextLine();
            opcao = leitura.nextInt();
        }
        
        return listaTarefas;
    }

    private static Pessoa lerPessoa(Scanner leitura) {
        System.out.println("\nDigite o nome da pessoa: \n");
        String nome = leitura.next();
        System.out.println("\nDigite o CPF da pessoa: \n");
        long cpf = leitura.nextLong();
        return new Pessoa(cpf, nome);
    }
}
