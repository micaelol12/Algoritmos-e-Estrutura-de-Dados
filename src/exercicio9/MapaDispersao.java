package exercicio9;

import exercicio3.ListaEncadeada;
import exercicio3.NoLista;

public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    @SuppressWarnings("unchecked")
    public MapaDispersao(int tamanho) {
        setInfo(new ListaEncadeada[tamanho]);
    }

    private int calcularHash(int chave) {
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        if (getInfo()[indice] == null) {
            getInfo()[indice] = new ListaEncadeada<NoMapa<T>>();
        }

        NoMapa<T> noMapa = new NoMapa<>();

        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        getInfo()[indice].inserir(noMapa);
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);

        ListaEncadeada<NoMapa<T>> lista = getInfo()[indice];

        if (lista != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = lista.buscar(noMapa);

            if (no != null) {
                return no.getInfo().getInfo();
            }
        }

        return null;
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        ListaEncadeada<NoMapa<T>> lista = getInfo()[indice];

        if (lista != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            lista.retirar(noMapa);

        }

    }

    public ListaEncadeada<NoMapa<T>>[] getInfo() {
        return info;
    }

    public void setInfo(ListaEncadeada<NoMapa<T>>[] info) {
        this.info = info;
    }

}
