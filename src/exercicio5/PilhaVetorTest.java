package exercicio5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    void test4() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(3);
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);
        try {
            inteiros.push(40);
            fail();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    void test5() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(3);

        try {
            inteiros.pop();
            fail();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    void test6() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(5);
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);

        assertEquals((Integer) 30, inteiros.peek());
    }

    @Test
    void test7() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(5);
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);

        inteiros.liberar();

        assertTrue(inteiros.estaVazia());
    }

    @Test
    void test8() {
        PilhaVetor<Integer> inteiros = new PilhaVetor<>(5);
        inteiros.push(10);
        inteiros.push(20);
        inteiros.push(30);

        PilhaVetor<Integer> inteiros2 = new PilhaVetor<>(5);
        inteiros2.push(40);
        inteiros2.push(50);

        inteiros.concatenar(inteiros2);

        assertEquals("50, 40, 30, 20, 10", inteiros.toString());
    }

}
