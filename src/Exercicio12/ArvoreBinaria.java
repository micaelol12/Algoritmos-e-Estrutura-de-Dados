package Exercicio12;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    NoArvoreBinaria<T> raiz = super.getRaiz();

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(raiz, info);
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
