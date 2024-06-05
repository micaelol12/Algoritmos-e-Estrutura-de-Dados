package Exercicio11;

public class ListaEstatica<T> extends ListaAbstract<T> {
    public int buscar(T valor) {
        for (int i = 0; i < getTamanho(); i++) {
            Object aux = getInfo()[i];

            if (aux.equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void inserir(T valor) {
        if (getTamanho() == getInfo().length) {
            redimensionar();
        }
        getInfo()[getTamanho()] = valor;
        setTamanho(getTamanho() + 1);
    }

}
