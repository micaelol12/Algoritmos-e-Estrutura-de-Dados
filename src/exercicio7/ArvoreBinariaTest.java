package exercicio7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArvoreBinariaTest {
    ArvoreBinaria<Integer> inteiros = new ArvoreBinaria<>();

    @BeforeEach
    public void setUp() {
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);

        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<Integer>(7);

        no5.setEsquerda(no7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);

        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);

        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);

        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        inteiros.setRaiz(no1);

    }

    @Test
    void test1() {
        ArvoreBinaria<Integer> localInteiros = new ArvoreBinaria<>();
        assertTrue(localInteiros.estaVazia());
    }

    @Test
    void test2() {
        ArvoreBinaria<Integer> localInteiros = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);

        localInteiros.setRaiz(no5);

        assertFalse(localInteiros.estaVazia());
    }

    @Test
    void test3() {
        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", inteiros.toString());
    }

    @Test
    void test4() {
        assertTrue(inteiros.pertence(1));
    }

    @Test
    void test5() {
        assertTrue(inteiros.pertence(3));
    }

    @Test
    void test6() {
        assertTrue(inteiros.pertence(6));
    }

    @Test
    void test7() {
        assertFalse(inteiros.pertence(10));
    }

    @Test
    void test8() {
        assertEquals(6, inteiros.contarNos());
    }

    @Test
    void testProva() {
        assertEquals(2, inteiros.contarNosInternos(inteiros.getRaiz().getDireita()));
    }
}
