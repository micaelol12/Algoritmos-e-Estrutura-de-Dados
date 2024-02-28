package exercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaEstativaTest {
	
	
	@Test
	void test1() {
		ListaEstatica teste = new ListaEstatica();
		String retornoE = "5,10,15,20";
		
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);
		
		String retorno = teste.toString();
		
		assertEquals(retorno, retornoE);
	}

}
