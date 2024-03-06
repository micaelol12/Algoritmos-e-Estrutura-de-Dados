package exercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEstativaTest {
	ListaEstatica<Integer> teste = new ListaEstatica<>();

	@BeforeEach
	public void setUp() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

	}

	@Test
	void test1() {
		String retornoE = "20,15,10,5";

		teste.inverter();

		String retorno = teste.toString();

		assertEquals(retornoE,retorno);
	}

	@Test
	void test2() {
		teste.inserir(25);

		String retornoE = "25,20,15,10,5";

		teste.inverter();
		
		String retorno = teste.toString();

		assertEquals(retornoE,retorno);
	}

	
}
