package exercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEstativaTest {
	ListaEstatica teste = new ListaEstatica();
	
	   @BeforeEach
	    public void setUp() {
		   	teste.liberar();
			teste.inserir(5);
			teste.inserir(10);
			teste.inserir(15);
			teste.inserir(20);
			
	    }
	
	@Test
	void test1() {
		String retornoE = "5,10,15,20";
		
		String retorno = teste.toString();
		
		assertEquals(retorno, retornoE);
	}
	
	@Test
	void test2() {
		
		int tamanho = teste.getTamanho();
		
		assertEquals(tamanho, 4);
	}
	
	@Test
	void test3() {
		assertEquals(teste.buscar(15), 2);
	}
	
	@Test
	void test4() {
		assertEquals(teste.buscar(30), -1);
	}
	
	@Test
	void test5() {
		teste.retirar(10);
		
		String retornoE = "5,15,20";
		
		String retorno = teste.toString();
		assertEquals(retorno, retornoE);
	}
	
	@Test
	void test6() {
		ListaEstatica teste2 = new ListaEstatica();
		
		teste2.inserir(1);
		teste2.inserir(2);
		teste2.inserir(3);
		teste2.inserir(4);
		teste2.inserir(5);
		teste2.inserir(6);
		teste2.inserir(7);
		teste2.inserir(8);
		teste2.inserir(9);
		teste2.inserir(10);
		teste2.inserir(11);
		teste2.inserir(12);
		teste2.inserir(13);
		teste2.inserir(14);
		teste2.inserir(15);
		
		
		String retornoE = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
		
		String retorno = teste2.toString();
		assertEquals(retorno, retornoE);
	}
	
	@Test
	void test7() {

		
		int retornoE = 20 ;
		
		int retorno = teste.obterElemento(3);
		assertEquals(retorno, retornoE);
	}

	@Test
	void test8() {

		Exception exception = assertThrows(RuntimeException.class, () ->
        teste.obterElemento(5));
		
		assertEquals("Índice 5 fora dos limites para comprimento 4", exception.getMessage());
	}


	@Test
	void test9() {

		teste.liberar();
		
		assertEquals(teste.estaVazia(),true);
	}

}
