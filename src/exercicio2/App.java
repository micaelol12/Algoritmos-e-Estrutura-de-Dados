package exercicio2;

public class App {

    public static void main(String[] args) {
        ListaEstatica<Integer> nomes = new ListaEstatica<>();

        nomes.inserir(5);
        nomes.inserir(10);
        nomes.inserir(15);
        nomes.inserir(20);

        nomes.inverter();

    }
}
