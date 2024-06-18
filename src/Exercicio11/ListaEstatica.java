package Exercicio11;

public class ListaEstatica<T> extends ListaAbstract<T> {


    public void inserir(T valor) {
        if (info.length == tamanho) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public int buscar(T valor) {

        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}
