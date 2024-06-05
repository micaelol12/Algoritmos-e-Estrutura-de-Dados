package exercicio10;

public abstract class OrdenacaoAbstract<T extends Comparable<T>> {
    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void trocar(int a, int b) {
        if (a == b) {
            return;
        }

        T temp = getInfo()[a];
        getInfo()[a] = getInfo()[b];
        getInfo()[b] = temp;
    }

    public abstract void ordenar();

}
