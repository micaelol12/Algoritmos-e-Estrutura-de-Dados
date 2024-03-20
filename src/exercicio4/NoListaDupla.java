package exercicio4;

public class NoListaDupla<T> {

    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;
    private T info;

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}
