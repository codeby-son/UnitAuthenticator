/**
 * Implementa uma tabela hash para armazenar usuários e senhas.
 *
 * Utiliza listas simplesmente encadeadas para tratar colisões.
 */
public class TabelaHash {

    /**
     * Capacidade máxima da tabela hash.
     */
    private int capacidade;

    /**
     * Vetor de listas encadeadas utilizado para armazenar
     * os usuários e tratar colisões.
     */
    private ListaEncadeada[] tabela;
    /**
     * Cria uma tabela hash com a capacidade informada.
     *
     * @param capacidade quantidade de posições da tabela
     * @throws IllegalArgumentException se a capacidade for menor ou igual a zero
     */
    public TabelaHash(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero;");
        }

        this.capacidade = capacidade;
        this.tabela = new ListaEncadeada[capacidade];

        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new ListaEncadeada();

        }
    }

    /**
     * Calcula o índice de armazenamento de um usuário na tabela.
     *
     * @param nome nome utilizado para calcular o índice
     * @return índice correspondente na tabela hash
     */
    private int calcularIndice(String nome) {
        int indice = Math.floorMod(nome.hashCode(), capacidade);
        return indice;
    }

    /**
     * Insere um usuário na tabela hash.
     *
     * Não permite nomes repetidos.
     *
     * @param nome nome do usuário
     * @param senha senha do usuário
     * @return true se o usuário foi inserido, false se o nome já estava cadastrado
     * @throws IllegalArgumentException se o nome ou a senha forem nulos
     */
    public boolean inserir(String nome, String senha) {
        if (nome == null || senha == null) {
            throw new IllegalArgumentException("Nome e senha não podem ser nulos;");
        }

        int indice = calcularIndice(nome);
        return tabela[indice].inserir(nome, senha);
    }
    /**
     * Verifica se um usuário está cadastrado na tabela hash.
     *
     * @param nome nome do usuário
     * @return true se o usuário existe, false caso contrário
     * @throws IllegalArgumentException se o nome for nulo
     */
    public boolean existe(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo;");
        }

        int indice = calcularIndice(nome);
        return tabela[indice].existe(nome);
    }

    /**
     * Busca a senha de um usuário na tabela hash.
     *
     * @param nome nome do usuário
     * @return senha do usuário ou null se o usuário não existir
     * @throws IllegalArgumentException se o nome for nulo
     */
    public String buscar(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo;");
        }

        int indice = calcularIndice(nome);
        return tabela[indice].buscar(nome);
    }

    /**
     * Autentica um usuário verificando o nome e a senha.
     *
     * @param nome nome do usuário
     * @param senha senha informada
     * @return true se o nome existe e a senha confere, false caso contrário
     * @throws IllegalArgumentException se o nome ou a senha forem nulos
     */
    public boolean autenticar(String nome, String senha) {
        if (nome == null || senha == null) {
            throw new IllegalArgumentException("Nome e senha não podem ser nulos;");
        }

        int indice = calcularIndice(nome);
        return tabela[indice].autenticar(nome, senha);
    }
    /**
     * Remove um usuário da tabela hash.
     *
     * @param nome nome do usuário
     * @return true se o usuário foi removido, false se não existia
     * @throws IllegalArgumentException se o nome for nulo
     */
    public boolean remover(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo;");
        }

        int indice = calcularIndice(nome);
        return tabela[indice].remover(nome);
    }

}