package exercicio6;

public interface Fila<T> {

    void inserir(T valor) throws FilaCheiaException;

    boolean estaVazia();

    T peek();

    T retirar() throws FilaVaziaException;

    void liberar();

}
