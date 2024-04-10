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

        int posicaoInserir;
        posicaoInserir = (getInicio() + getTamanho()) % getLimite();
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

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novaLista = new FilaVetor<>(getLimite() + f2.getLimite());

        int inicio = 0;

        for (int i = getInicio(); i < getTamanho(); i++) {
            int posi = getLimite() % (i + 1);

            T valor = getInfo()[posi];

            novaLista.inserir(valor);
            inicio = i;
        }

        for (int i = 0; i < f2.getTamanho(); i++) {
            T valor = f2.getInfo()[inicio + i];

            if (valor != null) {
                novaLista.inserir(valor);
            }
        }

        return novaLista;

    }

    public String toString() {
        String str = "";

        for (int i = getInicio(); i < getTamanho(); i++) {

            if (i != getInicio()) {
                str += ", ";
            }

            int posi = getLimite() % (i + getTamanho());

            T valor = getInfo()[posi];

            str += valor.toString();

        }

        return str;
    };

}
