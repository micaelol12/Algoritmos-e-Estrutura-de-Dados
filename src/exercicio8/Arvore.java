package exercicio8;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        setRaiz(null);
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo() == info) {
            return true;
        }

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            if (pertence(p, info)) {
                return true;
            }
            p = p.getProximo();
        }

        return false;
    }

    public boolean pertence(T info) {
        if (getRaiz() == null) {
            return false;
        }

        return pertence(getRaiz(), info);
    };

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<";

        s += no.getInfo();

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        s += ">";
        
        return s;
    }

    public String toString() {
        if (getRaiz() == null) {
            return "";
        }

        return obterRepresentacaoTextual(getRaiz());
    }

    private int ContarNos(NoArvore<T> no){
        int i = 0;

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            i += ContarNos(p);
            p = p.getProximo();
        }

        return i + 1;
    }

    public int ContarNos(){
        if (getRaiz() == null) {
            return 0;
        }

        return ContarNos(getRaiz());
    }

}
