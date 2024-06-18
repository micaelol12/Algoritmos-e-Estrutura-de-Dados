package Exercicio12;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        if (no.getInfo().equals(info)) {
            return no;
        }

        NoArvoreBinaria<T> resultadoEsquerda = buscar(no.getEsquerda(), info);

        if (resultadoEsquerda != null) {
            return resultadoEsquerda;
        }

        NoArvoreBinaria<T> resultadoDireita = buscar(no.getDireita(), info);

        return resultadoDireita;
    }

}
