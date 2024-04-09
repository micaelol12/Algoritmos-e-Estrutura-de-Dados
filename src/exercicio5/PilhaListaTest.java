package exercicio5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PilhaListaTest {

    @Test
    void test1() {
        PilhaLista<Integer> inteiros = new PilhaLista<>();
        assertTrue(inteiros.estaVazia());
    }

    @Test
    void test2() {
        PilhaLista<Integer> inteiros = new PilhaLista<>();
        inteiros.push(10);
        assertFalse(inteiros.estaVazia());
    }

    @Test
    void test3() {
        PilhaLista<Integer> inteiros = new PilhaLista<>();
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);

        assertEquals((Integer) 30, inteiros.pop());
        assertEquals((Integer) 20, inteiros.pop());
        assertEquals((Integer) 10, inteiros.pop());
        assertTrue(inteiros.estaVazia());

    }

    @Test
    void test4() {
        PilhaLista<Integer> inteiros = new PilhaLista<>();
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);

        assertEquals((Integer) 30, inteiros.peek());
        assertEquals((Integer) 30, inteiros.pop());

    }

    @Test
    void test5() {
        PilhaLista<Integer> inteiros = new PilhaLista<>();
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);

        inteiros.liberar();
        assertTrue(inteiros.estaVazia());

    }
}
