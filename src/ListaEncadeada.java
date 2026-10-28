import java.io.ByteArrayInputStream;

public class ListaEncadeada {

    private class No {
        String nome;
        String senha;
        No proximo;

        public No(String nome, String senha) {
            this.nome = nome;
            this.senha = senha;
            this.proximo = null;
        }
    }

    private No inicio;

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

