package exercicio5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class PilhaVetorTest {

    @Test
    void test1() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(5);
        assertTrue(inteiros.estaVazia());
    }

    @Test
    void test2() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(5);
        inteiros.push(10);
        assertFalse(inteiros.estaVazia());
    }

    @Test
    void test3() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(10);
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);
        assertEquals((Integer) 30, inteiros.pop());
        assertEquals((Integer) 20, inteiros.pop());
        assertEquals((Integer) 10, inteiros.pop());
        assertTrue(inteiros.estaVazia());
    }



}
