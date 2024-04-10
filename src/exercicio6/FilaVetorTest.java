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
    void test8() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(5);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);

        inteiros.liberar();

        assertTrue(inteiros.estaVazia());
    }

    @Test
    void test9() {
        FilaVetor<Integer> inteiros = new FilaVetor<>(5);
        inteiros.inserir(10);
        inteiros.inserir(20);
        inteiros.inserir(30);
        inteiros.inserir(40);
       

        assertEquals("10, 20, 30, 40", inteiros.toString());
    }

}