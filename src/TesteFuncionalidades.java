/**
 * Classe responsável por testar as funcionalidades da tabela hash:
 * busca, autenticação, remoção e verificação de existência.
 *
 * Cada teste mostra o resultado esperado e o resultado obtido.
 */
public class TesteFuncionalidades {
    /**
     * Quantidade de testes que passaram.
     */
    private static int acertos = 0;

    /**
     * Quantidade total de testes executados.
     */
    private static int total = 0;

    /**
     * Compara o resultado esperado com o obtido e exibe o resultado do teste.
     *
     * @param descricao descrição do teste
     * @param esperado valor esperado
     * @param obtido valor obtido
     */
    private static void verificar(String descricao, Object esperado, Object obtido) {
        total++;

        boolean passou = (esperado == null) ? (obtido == null) : esperado.equals(obtido);

        if (passou) {
            acertos++;
            System.out.println("[OK]   " + descricao);
        } else {
            System.out.println("[ERRO] " + descricao + " | esperado: " + esperado + " | obtido: " + obtido);
        }
    }

    /**
     * Executa todos os testes de sucesso e de erro.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        // Capacidade pequena para forçar colisões
        TabelaHash tabelaHash = new TabelaHash(3);

        tabelaHash.inserir("Ícaro", "123");
        tabelaHash.inserir("Pedro", "456");
        tabelaHash.inserir("Rennyson", "789");
        tabelaHash.inserir("Maria", "abc");
        tabelaHash.inserir("Joao", "xyz");

        System.out.println("=== Inserção (nomes repetidos) ===");
        verificar("Inserir nome repetido deve falhar", false, tabelaHash.inserir("Pedro", "outra"));
        verificar("Senha original deve continuar a mesma", "456", tabelaHash.buscar("Pedro"));
        verificar("Inserir novo nome deve funcionar", true, tabelaHash.inserir("Ana", "111"));

        System.out.println("\n=== Verificação de existência ===");
        verificar("Usuário cadastrado existe", true, tabelaHash.existe("Ícaro"));
        verificar("Usuário não cadastrado não existe", false, tabelaHash.existe("Carlos"));
        verificar("Nome diferente de maiúsculas/minúsculas não existe", false, tabelaHash.existe("pedro"));

        System.out.println("\n=== Busca ===");
        verificar("Buscar usuário existente retorna a senha", "789", tabelaHash.buscar("Rennyson"));
        verificar("Buscar usuário inexistente retorna null", null, tabelaHash.buscar("Carlos"));
        verificar("Buscar usuário em colisão (Maria)", "abc", tabelaHash.buscar("Maria"));
        verificar("Buscar usuário em colisão (Joao)", "xyz", tabelaHash.buscar("Joao"));

        System.out.println("\n=== Autenticação ===");
        verificar("Login com nome e senha corretos", true, tabelaHash.autenticar("Ícaro", "123"));
        verificar("Login com senha errada", false, tabelaHash.autenticar("Ícaro", "999"));
        verificar("Login com usuário inexistente", false, tabelaHash.autenticar("Carlos", "123"));
        verificar("Login com senha de outro usuário", false, tabelaHash.autenticar("Pedro", "123"));

        System.out.println("\n=== Remoção ===");
        verificar("Remover usuário existente", true, tabelaHash.remover("Pedro"));
        verificar("Usuário removido não existe mais", false, tabelaHash.existe("Pedro"));
        verificar("Login do usuário removido falha", false, tabelaHash.autenticar("Pedro", "456"));
        verificar("Remover usuário já removido", false, tabelaHash.remover("Pedro"));
        verificar("Remover usuário inexistente", false, tabelaHash.remover("Carlos"));
        verificar("Outros usuários continuam cadastrados", true, tabelaHash.existe("Ícaro"));
        verificar("Reinserir usuário removido", true, tabelaHash.inserir("Pedro", "nova"));
        verificar("Reinserido tem a nova senha", "nova", tabelaHash.buscar("Pedro"));

        System.out.println("\n=== Valores nulos ===");
        try {
            tabelaHash.existe(null);
            verificar("existe(null) deve lançar exceção", true, false);
        } catch (IllegalArgumentException e) {
            verificar("existe(null) lança IllegalArgumentException", true, true);
        }

        try {
            tabelaHash.autenticar("Ícaro", null);
            verificar("autenticar com senha nula deve lançar exceção", true, false);
        } catch (IllegalArgumentException e) {
            verificar("autenticar com senha nula lança IllegalArgumentException", true, true);
        }

        System.out.println("\nResultado: " + acertos + " de " + total + " testes passaram.");
    }
}