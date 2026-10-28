public class TabelaHash {

    private int capacidade;
    private ListaEncadeada[] tabela;

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

    private int calcularIndice(String nome) {
        int indice = Math.floorMod(nome.hashCode(), capacidade);
        return indice;
    }

    public void inserir(String nome, String senha) {
        if (nome == null || senha == null) {
            throw new IllegalArgumentException("Nome e senha não podem ser nulos;");
        }

        int indice = calcularIndice(nome);
        tabela[indice].inserir(nome, senha);
    }

}
