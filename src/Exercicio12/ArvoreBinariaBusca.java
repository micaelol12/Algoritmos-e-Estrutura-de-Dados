package Exercicio12;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    NoArvoreBinaria<T> raiz = super.getRaiz();

    public void inserir(T valor) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);
        if (raiz == null) {
            raiz = novo;
        } else {
            NoArvoreBinaria<T> p = raiz;
            while (true) {
                NoArvoreBinaria<T> pai = p;
                if (valor.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscarRecursivo(info, raiz);
    }

    private NoArvoreBinaria<T> buscarRecursivo(T info, NoArvoreBinaria<T> no) {
        if (no == null) {
            return null;
        }

        if (info.equals(no.getInfo())) {
            return no;
        } else if (info.compareTo(no.getInfo()) < 0) {
            return buscarRecursivo(info, no.getEsquerda());
        } else {
            return buscarRecursivo(info, no.getDireita());
        }
    }
}