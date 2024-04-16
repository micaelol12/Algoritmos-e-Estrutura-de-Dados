package exercicio6;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    @SuppressWarnings("unchecked")
    public FilaVetor(int limite) {
        setInfo((T[]) new Object[limite]);
        setLimite(limite);
        setTamanho(0);
        setInicio(0);
    }

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void inserir(T valor) throws FilaCheiaException {
        if (getTamanho() == getLimite()) {
            throw new FilaCheiaException();
        }

        int posicaoInserir = (getInicio() + getTamanho()) % getLimite();
        getInfo()[posicaoInserir] = valor;
        setTamanho(getTamanho() + 1);
    }

    public boolean estaVazia() {
        return getTamanho() == 0;
    }

    public T peek() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return getInfo()[getInicio()];
    }

    public T retirar() {
        T valor = peek();

        getInfo()[inicio] = null;

        setInicio((getInicio() + 1) % getLimite());

        setTamanho(getTamanho() - 1);

        return valor;
    }

    public void liberar() {
        try {
            while (true) {
                retirar();
            }
        } catch (RuntimeException e) {
            // TODO: handle exception
        }
    };

    private int concatenaListas(int indice, FilaVetor<T> fv, FilaVetor<T> novaFila) {
        for (int i = 0; i < fv.getTamanho(); i++) {
            novaFila.inserir(fv.getInfo()[indice]);
            indice = (indice + 1) % fv.getLimite();
        }

        return indice;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novaFila = new FilaVetor<>(getLimite() + f2.getLimite());

        int indice = getInicio();

        concatenaListas(indice, this, novaFila);

        concatenaListas(indice, f2, novaFila);

        return novaFila;

    }

    public String toString() {
        String str = "";

        int indice = inicio;
        for (int i = 0; i < getTamanho(); i++) {

            if (i > 0) {
                str += ", ";
            }

            T valor = getInfo()[indice];

            str += valor.toString();

            indice = (indice + 1) % limite;
        }

        return str;
    };

}
