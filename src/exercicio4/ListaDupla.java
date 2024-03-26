package exercicio4;

public class ListaDupla<T> {
    NoListaDupla<T> primeiro;

    public ListaDupla() {
        setPrimeiro(null);
    }

    public void inserir(T valor) {
        NoListaDupla<T> novoValor = new NoListaDupla<>();

        novoValor.setInfo(valor);
        novoValor.setProximo(primeiro);
        novoValor.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novoValor);
        }

        setPrimeiro(novoValor);
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = getPrimeiro();

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            } else {
                p = p.getProximo();

            }
        }

        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        if (p != null) {
            NoListaDupla<T> proximo = p.getProximo();
            NoListaDupla<T> anterior = p.getAnterior();

            if (anterior == null) {
                setPrimeiro(proximo);
            } else {
                anterior.setProximo(proximo);
            }

            if (proximo != null) {
                proximo.setAnterior(anterior);
            }
        }
    }

    private NoListaDupla<T> obterUltimo() {
        NoListaDupla<T> p = getPrimeiro();

        while (p.getProximo() != null) {
            p = p.getProximo();
        }

        return p;

    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = obterUltimo();

        while (p != null) {
            System.out.println(p.getInfo().toString());
            p = p.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = getPrimeiro();

        while (p != null) {
            NoListaDupla<T> proximo = p.getProximo();

            p.setAnterior(null);
            p.setProximo(null);

            p = proximo;
        }

        setPrimeiro(null);
    }

    public String toString() {
        NoListaDupla<T> p = getPrimeiro();

        String str = "";

        while (p != null) {
            if (p != primeiro) {
                str += ", ";

            }

            str += p.getInfo().toString();
            p = p.getProximo();
        }

        return str;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaDupla<T> primeiro) {
        this.primeiro = primeiro;
    }
}
