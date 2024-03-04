package exercicio1;

public class ListaEstatica {
	
private int[] info;
	
private int tamanho;
	
 public ListaEstatica() {
	setInfo(new int[10]);
	setTamanho(0);
}
 
 private void redimensionar() {
	 int novoTamanho = getTamanho() + 10;
	 int[] novoVetor = new int[novoTamanho];
	 for(int i = 0;i  <= getTamanho()-1;i++) {
		 novoVetor[i] = getInfo()[i];
	 }
	 setInfo(novoVetor);
 }
 
 public void inserir(int valor) {
	 if(getTamanho() == getInfo().length) {
		 redimensionar();
	 }
	 getInfo()[getTamanho()] = valor;
	 setTamanho(getTamanho() + 1);;
 }
 
 public void exibir() {
	 
 }
 
 public int buscar(int valor) {
	for(int i =0; i <= getTamanho() -1;i++) {
		int aux = getInfo()[i];
		
		if(aux == valor) {
			return i;
		}
	}
	return -1;
 }
 
 public void retirar(int valor) {
	 int posicao = buscar(valor);
	 
	 if(posicao == -1) {
		 return;
	 }
	 
	 for(int i = posicao + 1;i <= getTamanho() -1;i++) {
		 int aux = getInfo()[i];
		 getInfo()[i -1] = aux;
	 }
	 
	 
	 setTamanho(getTamanho() -1);;
 }
 
 public void liberar() {
	 int[] novoVetor = new int[10];
	 setTamanho(0);
	 setInfo(novoVetor);
 }
 
 public int obterElemento(int posicao) {
	if(posicao > getTamanho()){
		throw new IndexOutOfBoundsException("Índice " + posicao + " fora dos limites para comprimento " + getTamanho() );
	}
	 int valor = getInfo()[posicao];
	 return valor;
 }
 
 public boolean estaVazia() {
	 return getTamanho() == 0;
 }
 
 public String toString() {
	 String valor = "";
	 
		for(int i =0; i <= getTamanho() -1;i++) {
			valor += getInfo()[i];
			
			if(i != getTamanho() -1) {
				valor += ",";
			}
			
		}
		
		return valor;
 }
 
public int[] getInfo() {
	return info;
}
public void setInfo(int[] info) {
	this.info = info;
}
public int getTamanho() {
	return tamanho;
}
public void setTamanho(int tamanho) {
	this.tamanho = tamanho;
}
 
 
}
