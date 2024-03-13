package exercicio3;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        setPrimeiro(null);
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoLista<T> primeiro) {
        this.primeiro = primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<T>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        setPrimeiro(novo);
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {

        NoLista<T> p = primeiro;

        while (p != null) {

            if (p.getInfo().equals(info)) {
                return p;
            } else {
                p = p.getProximo();
            }
        }

        return null;
    }

    public void retirar(T info) {

        NoLista<T> p = primeiro;
        NoLista<T> anterior = null;
        // Procura o nó
        while (p != null && p.getInfo() != info) {
            anterior = p;
            p = p.getProximo();
        }

        // Se Achou o nó o retira da lista
        if (p != null) {
            if (p == primeiro) {
                setPrimeiro((p.getProximo()));
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        NoLista<T> p = primeiro;

        int comprimento = 0;

        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }

        return comprimento;
    }

    public NoLista<T> obterNo(int idx) throws java.lang.IndexOutOfBoundsException {
        NoLista<T> p = primeiro;
        int comprimento = obterComprimento();
        int posicao = 0;

        if (idx < 0 || idx > comprimento) {
            throw new IndexOutOfBoundsException();
        }

        while (p != null) {
            if (posicao == idx) {
                return p;
            }
            posicao++;
            p = p.getProximo();
        }

        return null;
    }

    public String toString(){
        NoLista<T> p = primeiro;

        String str = "";

        while (p != null) {
            str += ", ";
            str += p.getInfo();
            p = p.getProximo();
        }

        return str;
    }
}
