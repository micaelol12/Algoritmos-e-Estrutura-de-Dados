package Exercicio12;


public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        raiz = null;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    @Override
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
        }
    }

    public int ContarNos() {
        return ContarNos(raiz);
    }

    private int ContarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + ContarNos(no.getEsquerda()) + ContarNos(no.getDireita());
        }
    }

    public int contarFolhas(NoArvoreBinaria<T> sa) {
        if (sa == null) {
            return 0;
        } else if (sa.getDireita() == null && sa.getEsquerda() == null) {
            return 1;
        }

        return contarFolhas(sa.getDireita()) + contarFolhas(sa.getEsquerda());
    }

}
