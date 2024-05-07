package exercicio6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FilaVetorTest {

    @Test
    void test1() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(5);
        assertTrue(inteiros.estaVazia());
    }

    @Test
    void test2() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(5);
        inteiros.inserir(10);
        assertFalse(inteiros.estaVazia());
    }

    @Test
    void test3() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(10);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);

        assertEquals((Integer) 10, inteiros.retirar());
        assertEquals((Integer) 20, inteiros.retirar());
        assertEquals((Integer) 30, inteiros.retirar());

        assertTrue(inteiros.estaVazia());
    }

    @Test
    void test4() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(3);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);

        try {
            inteiros.inserir(40);
            fail();
        } catch (FilaCheiaException e) {
            // TODO: handle exception
        }
    }

    @Test
    void test5() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(3);

        try {
            inteiros.retirar();
            fail();
        } catch (FilaVaziaException e) {
            // TODO: handle exception
        }
    }

    @Test
    void test6() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(3);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);

        assertEquals((Integer) 10, inteiros.retirar());
    }

    @Test
    void test7() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(5);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);

        inteiros.liberar();

        assertTrue(inteiros.estaVazia());
    }

    @Test
    void testPRovar() {
        FilaVetor<Character> chars = new FilaVetor<>(5);
        chars.inserir('A');
        chars.inserir('A');
        chars.inserir('A');

        chars.retirar();
        chars.retirar();
        chars.retirar();

        chars.inserir('A');
        chars.inserir('B');
        chars.inserir('C');
        chars.inserir('D');


        chars.encolher();

        assertEquals(4,chars.getLimite());
        assertEquals(4,chars.getTamanho());
        assertEquals(0,chars.getInicio());
        assertEquals("A, B, C, D", chars.toString());
    }

    @Test
    void test8() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(5);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);

        FilaVetor<Integer> inteiros2 = new FilaVetor<>(3);
        inteiros2.inserir(40);
        inteiros2.inserir(50);

        FilaVetor<Integer> inteiros3 = inteiros.criarFilaConcatenada(inteiros2);

        assertEquals("10, 20, 30", inteiros.toString());
        assertEquals("40, 50", inteiros2.toString());
        assertEquals(8, inteiros3.getLimite());

        assertEquals("10, 20, 30, 40, 50", inteiros3.toString());
    }

}
