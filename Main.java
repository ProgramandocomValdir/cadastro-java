import java.util.ArrayList;
import java.util.Scanner;

// Classe que representa o usuário do sistema.
// Aqui ficam apenas os dados que o usuário possui.
class Usuario {
    String nome;
    String email;

    // Construtor usado para criar um usuário já com nome e email
    Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}

public class Main {

    // Lista onde os usuários cadastrados ficam armazenados
    // Enquanto o programa estiver rodando, os dados ficam aqui
    static ArrayList<Usuario> usuarios = new ArrayList<>();

    // Scanner utilizado para ler as informações digitadas no terminal
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        // Esse loop mantém o menu rodando até o usuário escolher sair
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção digitada pelo usuário
            opcao = scanner.nextInt();

            // Limpa o ENTER que sobra no buffer do Scanner
            scanner.nextLine();

            // Verifica a opção escolhida e chama o método correspondente
            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Método responsável por cadastrar um novo usuário
    // Ele lê os dados, cria o objeto e adiciona na lista
    static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Cria um novo usuário e adiciona na lista
        usuarios.add(new Usuario(nome, email));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Método responsável por listar todos os usuários cadastrados
    static void listarUsuarios() {

         // Verifica se a lista está vazia antes de tentar mostrar os dados
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

        // Percorre a lista e mostra os dados de cada usuário
        for (Usuario u : usuarios) {
            System.out.println("Nome: " + u.nome + " | Email: " + u.email);
        }
    }
}
