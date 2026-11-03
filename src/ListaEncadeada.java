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
     * Insere um novo usuário no final da lista encadeada.
     *
     * @param nome nome do usuário
     * @param senha senha do usuário
     */
    public void inserir(String nome, String senha) {

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
    }
}

