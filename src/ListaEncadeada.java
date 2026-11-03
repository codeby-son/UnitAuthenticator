/**
 * Implementa uma lista simplesmente encadeada para armazenar
 * usuários e senhas.
 *
 * É utilizada pela tabela hash para tratar colisões.
 */
public class ListaEncadeada {

    /**
     * Representa um nó da lista, armazenando os dados
     * do usuário e a referência para o próximo nó.
     */
    private class No {
        String nome;
        String senha;
        No proximo;

        /**
         * Cria um novo nó com os dados do usuário.
         *
         * @param nome nome do usuário
         * @param senha senha do usuário
         */
        public No(String nome, String senha) {
            this.nome = nome;
            this.senha = senha;
            this.proximo = null;
        }
    }

    /**
     * Referência para o primeiro nó da lista.
     */
    private No inicio;
    /**
     * Procura um nó na lista pelo nome do usuário.
     *
     * @param nome nome do usuário procurado
     * @return nó encontrado ou null se o usuário não existir
     */
    private No buscarNo(String nome) {
        No atual = inicio;

        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return atual;
            }

            atual = atual.proximo;
        }

        return null;
    }

    /**
     * Insere um novo usuário no final da lista encadeada.
     * Não permite nomes repetidos.
     *
     * @param nome nome do usuário
     * @param senha senha do usuário
     * @return true se o usuário foi inserido, false se o nome já estava cadastrado
     */
    public boolean inserir(String nome, String senha) {

        if (existe(nome)) {
            return false;
        }

        No novo = new No(nome, senha);

        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novo;
        }

        return true;
    }

    /**
     * Verifica se um usuário está cadastrado na lista.
     *
     * @param nome nome do usuário
     * @return true se o usuário existe, false caso contrário
     */
    public boolean existe(String nome) {
        return buscarNo(nome) != null;
    }

    /**
     * Busca a senha de um usuário na lista.
     *
     * @param nome nome do usuário
     * @return senha do usuário ou null se o usuário não existir
     */
    public String buscar(String nome) {
        No encontrado = buscarNo(nome);

        if (encontrado == null) {
            return null;
        }

        return encontrado.senha;
    }

    /**
     * Verifica se o nome existe e se a senha informada
     * corresponde à senha armazenada.
     *
     * @param nome nome do usuário
     * @param senha senha informada
     * @return true se o nome existe e a senha confere, false caso contrário
     */
    public boolean autenticar(String nome, String senha) {
        No encontrado = buscarNo(nome);

        if (encontrado == null) {
            return false;
        }

        return encontrado.senha.equals(senha);
    }

    /**
     * Remove um usuário da lista encadeada.
     *
     * @param nome nome do usuário
     * @return true se o usuário foi removido, false se não existia
     */
    public boolean remover(String nome) {
        No atual = inicio;
        No anterior = null;

        while (atual != null) {
            if (atual.nome.equals(nome)) {
                if (anterior == null) {
                    inicio = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }

                return true;
            }

            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }
}