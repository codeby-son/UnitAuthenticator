public class Main {
    static void main(String[] args) {

        TabelaHash tabelaHash = new TabelaHash(10);

        tabelaHash.inserir("Ícaro", "123");
        tabelaHash.inserir("Pedro", "456");
        tabelaHash.inserir("Rennyson", "789");

        System.out.println("Usuários inseriodos na tabela!");

    }
}
