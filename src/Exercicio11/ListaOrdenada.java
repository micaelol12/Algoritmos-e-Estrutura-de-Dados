package Exercicio11;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        int posicao = procurarPosicaoInclusao(valor);

        if (posicao < getTamanho()) {
            deslocarDados(posicao);
        }else {
            redimensionar();
        }

        Object[] info = getInfo(); // por causa do redimensionamento
        info[posicao] = valor;

        this.setTamanho(getTamanho() + 1);
    }

    private int procurarPosicaoInclusao(T itemAdicionar) {

        Object[] info = getInfo();
        int i;

        for (i = 0; i < getTamanho(); i++) {
            if (itemAdicionar.compareTo((T) info[i]) < 0) {
                return i;
            }
        }

        return i;
    }

    private void deslocarDados(int posicao) {
        Object[] info = getInfo();

        for (int j = getTamanho() - 1; j >= posicao; j--) {
            info[j + 1] = info[j];
        }
    }

    @Override
    public int buscar(T valor) {
        int inicio = 0;
        int fim = getTamanho() - 1;
        while (inicio <= fim) {
            int meio = ((inicio + fim) / 2);
            int comparacao = valor.compareTo((T) getInfo()[meio]);
            if (comparacao < 0) {
                fim = meio - 1;
            } else {
                if (comparacao > 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
        }

        return -1;
    }

}
