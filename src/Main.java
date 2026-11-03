import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TabelaHash tabelaHash = new TabelaHash(10);

        tabelaHash.inserir("Ícaro", "123");
        tabelaHash.inserir("Pedro", "456");
        tabelaHash.inserir("Rennyson", "789");

        System.out.println("Usuários inseridos na tabela!");

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n===== UNIT AUTHENTICATOR =====");
            System.out.println("1 - Inserir usuário");
            System.out.println("2 - Remover usuário");
            System.out.println("3 - Buscar usuário");
            System.out.println("4 - Login");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine().trim();

                        System.out.print("Digite a senha: ");
                        String senha = scanner.nextLine();

                        if (nome.isEmpty() || senha.isEmpty()) {
                            System.out.println("Preencha todos os campos.");
                        } else if (tabelaHash.inserir(nome, senha)) {
                            System.out.println("Usuário cadastrado com sucesso!");
                        } else {
                            System.out.println("Usuário já cadastrado.");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o nome do usuário: ");
                        String nomeRemover = scanner.nextLine().trim();

                        if (tabelaHash.remover(nomeRemover)) {
                            System.out.println("Usuário removido com sucesso!");
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o nome do usuário: ");
                        String nomeBuscar = scanner.nextLine().trim();

                        if (tabelaHash.existe(nomeBuscar)) {
                            System.out.println("Usuário encontrado!");
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("Nome do usuário: ");
                        String nomeLogin = scanner.nextLine().trim();

                        System.out.print("Senha: ");
                        String senhaLogin = scanner.nextLine();

                        if (tabelaHash.autenticar(nomeLogin, senhaLogin)) {
                            System.out.println("Login realizado com sucesso!");
                        } else {
                            System.out.println("Usuário ou senha incorretos.");
                        }
                        break;

                    case 5:
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção numérica válida.");
            }
        }

        scanner.close();
    }
}
