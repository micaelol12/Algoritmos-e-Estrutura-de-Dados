package exercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaEncadeadaTest {
	ListaEncadeada<Integer> teste = new ListaEncadeada<>();

	@BeforeEach
	public void setUp() {

	}

	@Test
	void test1() {
		assertEquals(true, teste.estaVazia());
	}

	@Test
	void test2() {
		teste.inserir(5);
		assertEquals(false, teste.estaVazia());
	}

	@Test
	void test3() {
		teste.inserir(5);

		NoLista<Integer> primeiro = teste.getPrimeiro();

		assertEquals(primeiro.getInfo(), 5);

		assertEquals(null, primeiro.getProximo());
	}

	@Test
	void test5() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		NoLista<Integer> primeiro = teste.buscar(20);

		assertEquals(primeiro.getInfo(), 20);

	}

	@Test
	void test6() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		NoLista<Integer> primeiro = teste.buscar(15);

		assertEquals(primeiro.getInfo(), 15);

	}

	@Test
	void test7() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		assertEquals(teste.buscar(50), null);

	}

	@Test
	void test8() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		teste.retirar(20);

		NoLista<Integer> p = teste.getPrimeiro();

		while (p != null) {
			if (p.getInfo() == 5 || p.getInfo() == 10 || p.getInfo() == 15) {
				p = p.getProximo();
			} else {
				fail("encontrou um número diferente");
			}
		}

	}

	@Test
	void test9() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		teste.retirar(15);

		NoLista<Integer> p = teste.getPrimeiro();

		while (p != null) {
			if (p.getInfo() == 5 || p.getInfo() == 10 || p.getInfo() == 20) {
				p = p.getProximo();
			} else {
				fail("encontrou um número diferente");
			}
		}

	}

	@Test
	void test10() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		assertEquals(teste.obterNo(0).getInfo(), 20);

	}

	@Test
	void test11() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		assertEquals(teste.obterNo(3).getInfo(), 5);

	}

	@Test
	void test12() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		try {
			teste.obterNo(10);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	void test13() {
		assertEquals(teste.obterComprimento(), 0);
	}

	@Test
	void test14() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		assertEquals(teste.obterComprimento(), 4);
	}

	@Test
	void test15() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		teste.retirar(5);

		assertEquals(10, teste.getUltimo().getInfo());
	}

	@Test
	void test16() {
		teste.inserir(5);
		teste.inserir(10);
		teste.inserir(15);
		teste.inserir(20);

		teste.inserirNoFinal(1);

		assertEquals("20, 15, 10, 5, 1", teste.toString());
	}

	@Test
	void test17() {
		teste.inserirNoFinal(5);
		teste.inserirNoFinal(10);
		teste.inserirNoFinal(15);
		teste.inserirNoFinal(20);

		assertEquals(5, teste.getPrimeiro().getInfo());
	}

}
