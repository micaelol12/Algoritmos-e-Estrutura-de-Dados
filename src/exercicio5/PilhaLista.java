package exercicio5;

import exercicio3.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<>();
    }

    public void push(T info) {
        lista.inserir(info);
    }

    public T pop() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public void liberar() {
        try {
            while (true) {
                pop();
            }
        } catch (PilhaVaziaException e) {
            // TODO: handle exception
        }
    }

    public String toString() {
        return lista.toString();
    }

}
