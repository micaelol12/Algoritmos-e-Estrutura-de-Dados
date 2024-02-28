package exercicio1;

public class ListaEstatica {
	
private int[] info;
	
private int tamanho;
	
 public ListaEstatica() {
	setInfo(new int[10]);
	setTamanho(0);
}
 
 private void redimensionar() {
	 int novoTamanho = tamanho + 10;
	 int[] novoVetor = new int[novoTamanho];
	 for(int i = 0;i  <= tamanho-1;i++) {
		 novoVetor[i] = info[i];
	 }
	 setInfo(novoVetor);
 }
 
 public void inserir(int valor) {
	 if(tamanho == info.length) {
		 redimensionar();
	 }
	 info[tamanho] = valor;
	 tamanho++;
 }
 
 public void exibir() {
	 
 }
 
 public int buscar(int valor) {
	for(int i =0; i <= tamanho -1;i++) {
		int aux = info[i];
		
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
	 
	 for(int i = posicao + 1;i <= tamanho -1;i++) {
		 int aux = info[i];
		 info[i -1] = aux;
	 }
	 
	 
	 tamanho--;
 }
 
 public void liberar() {
	 int[] novoVetor = new int[10];
	 setInfo(novoVetor);
 }
 
 public int obterElemento(int posicao) {
	 int valor = info[posicao];
	 return valor;
 }
 
 public boolean estaVazia() {
	 return tamanho == 0;
 }
 
 public String toString() {
	 String valor = "";
	 
		for(int i =0; i <= tamanho -1;i++) {
			valor += info[i];
			
			if(i != tamanho -1) {
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
