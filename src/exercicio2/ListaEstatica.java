package exercicio2;

public class ListaEstatica<T> {

	private Object[] info;

	private int tamanho;

	public ListaEstatica() {
		info = new Object[10];
		setTamanho(0);
	}

	private void redimensionar() {
		int novoTamanho = getTamanho() + 10;
		Object[] novoVetor = new Object[novoTamanho];

		for (int i = 0; i < getTamanho(); i++) {
			novoVetor[i] = getInfo()[i];
		}

		setInfo(novoVetor);
	}

	public void inserir(T valor) {
		if (getTamanho() == getInfo().length) {
			redimensionar();
		}
		getInfo()[getTamanho()] = valor;
		setTamanho(getTamanho() + 1);
	}

	public void exibir() {
		for (int i = 0; i < getTamanho(); i++) {
			System.out.println(getInfo()[i]);
		}
	}

	public int buscar(T valor) {
		for (int i = 0; i < getTamanho(); i++) {
			Object aux = getInfo()[i];

			if (aux.equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	public void retirar(T valor) {
		int posicao = buscar(valor);

		if (posicao == -1) {
			return;
		}

		for (int i = posicao + 1; i < getTamanho(); i++) {
			Object aux = getInfo()[i];
			getInfo()[i - 1] = aux;
		}

		setTamanho(getTamanho() - 1);

		getInfo()[tamanho] = null;
	}

	public void liberar() {
		Object[] novoVetor = new Object[10];
		setTamanho(0);
		setInfo(novoVetor);
	}

	@SuppressWarnings("unchecked")
	public T obterElemento(int posicao) throws IndexOutOfBoundsException {
		if (posicao > getTamanho()) {
			throw new IndexOutOfBoundsException(
					"Índice " + posicao + " fora dos limites para comprimento " + getTamanho());
		}

		T valor = (T) getInfo()[posicao];

		return valor;
	}

	public boolean estaVazia() {
		return getTamanho() == 0;
	}

	public String toString() {
		String valor = "";

		for (int i = 0; i < getTamanho(); i++) {
			valor += getInfo()[i];

			if (i != getTamanho() - 1) {
				valor += ",";
			}

		}

		return valor;
	}

	public void inverter() {
		for (int i = 0, j = getTamanho() - 1; i < j; i++, j--) {
			Object aux = getInfo()[i];
			Object aux1 = getInfo()[j];

			getInfo()[i] = aux1;
			getInfo()[j] = aux;
		}
	}

	public Object[] getInfo() {
		return info;
	}

	public void setInfo(Object[] info) {
		this.info = info;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
