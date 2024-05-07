package exercicio7;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return getRaiz() == null;
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }

        return no.getInfo() == info || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {

        if (no == null) {
            return "<>";
        }

        return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";

    }

    public String toString() {
        return arvorePre(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {

        if (no == null) {
            return 0;
        }

        return contarNos(no.getEsquerda()) + contarNos(no.getDireita()) + 1;
    }

    public int contarNosInternos(NoArvoreBinaria<T> sa){
        if (sa == null) {
            return 0;
        }

        if(sa.getEsquerda() == null && sa.getDireita() == null){
            return 0;
        }

        return contarNosInternos(sa.getEsquerda()) + contarNosInternos(sa.getDireita()) + 1;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

}
