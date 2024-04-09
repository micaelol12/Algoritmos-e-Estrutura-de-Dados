package exercicio5;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;

    private int limite;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public PilhaVetor(int limite) {
        setLimite(limite);
        setTamanho(0);
        setInfo((T[]) new Object[limite]);
    }

    public void push(T valor) throws PilhaCheiaException {

        if (getLimite() == getTamanho()) {
            throw new PilhaCheiaException();
        }

        getInfo()[tamanho] = valor;
        setTamanho(tamanho + 1);

    }

    public T peek() throws PilhaVaziaException {

        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return getInfo()[tamanho - 1];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public T pop() {
        T valor = peek();
        info[tamanho - 1] = null;
        setTamanho(tamanho - 1);
        return valor;
    }

    public void liberar() {
       try {
        while (true) {
            pop();
        }
       } catch (PilhaVaziaException e) {
        // TODO: handle exception
       }
    }

    public String toString() {
        String str = "";

        for (int i = getTamanho() - 1; i >= 0; i--) {
            if (i != getTamanho() - 1) {
                str += ", ";
            }

            str += getInfo()[i].toString();
        }

        return str;
    }

    public void concatenar(PilhaVetor<T> p) {

        if (p.getTamanho() + getTamanho() > limite) {
            throw new RuntimeException("Não há espaço para empilhar todos os dados");
        }

        for (int i = 0; i < p.getTamanho(); i++) {
            getInfo()[tamanho] = p.getInfo()[i];
            setTamanho(tamanho + 1);
        }
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

}
