package Exercicio11;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @SuppressWarnings("unchecked")
    @Override
    public void inserir(T valor) {
        Object[] info = getInfo();

        sePrecisarRedimensiona();

        boolean achou = false;

        int tamanho = getTamanho();

        if (tamanho == 0) {
            info[0] = valor;
            setTamanho(getTamanho() + 1);
            return;
        }

        for (int i = 0; i <= tamanho; i++) {
            if (((Comparable) valor).compareTo(info[i]) < 0) {
                achou = true;
                setTamanho(getTamanho() + 1);
            }

            if (achou) {
                Object aux = info[i];
                info[i] = valor;
                info[i + 1] = aux;
            }
        }
    }

    private void sePrecisarRedimensiona() {

        if (getTamanho() == getInfo().length) {
            redimensionar();
        }

      
    }

    @Override
    public int buscar(T valorBuscar) {
        @SuppressWarnings("unchecked")
        T[] info = (T[]) getInfo();

        int n = info.length;
        int inicio = 0;
        int fim = n - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (valorBuscar.compareTo(info[meio]) < 0) {
                fim = meio - 1; // redefine a posição final
            } else if (valorBuscar.compareTo(info[meio]) > 0) {
                inicio = meio + 1;// redefin a posição inicial
            } else {
                return meio;
            }

        }

        return -1;
    }

}
