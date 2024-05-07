package exercicio8;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArvoreTest {
    Arvore<Integer> arvore = new Arvore<>();

    @BeforeEach
    public void setUp() {

        NoArvore<Integer> n9 = new NoArvore<Integer>(9);
        NoArvore<Integer> n10 = new NoArvore<Integer>(10);

        NoArvore<Integer> n4 = new NoArvore<Integer>(4);

        n4.inserirFilho(n10);
        n4.inserirFilho(n9);

        NoArvore<Integer> n3 = new NoArvore<Integer>(3);

        NoArvore<Integer> n8 = new NoArvore<Integer>(8);

        n3.inserirFilho(n8);

        NoArvore<Integer> n7 = new NoArvore<Integer>(7);
        NoArvore<Integer> n6 = new NoArvore<Integer>(6);
        NoArvore<Integer> n5 = new NoArvore<Integer>(5);

        NoArvore<Integer> n2 = new NoArvore<Integer>(2);

        n2.inserirFilho(n7);
        n2.inserirFilho(n6);
        n2.inserirFilho(n5);

        NoArvore<Integer> n1 = new NoArvore<Integer>(1);

        n1.inserirFilho(n4);
        n1.inserirFilho(n3);
        n1.inserirFilho(n2);

        arvore.setRaiz(n1);
    }

    @Test
    void test1() {
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    void test2() {
        assertTrue(arvore.pertence(7));
    }

    @Test
    void test3() {
        assertFalse(arvore.pertence(55));
    }

    @Test
    void test4() {
        assertEquals(10, arvore.ContarNos());
    }

    @Test
    void test5() {
        assertFalse(arvore.isDegenerada());
    }


    @Test
    void test6() {
        Arvore<Integer> arvore2 = new Arvore<>();

        //NoArvore<Integer> n4 = new NoArvore<Integer>(7);

        NoArvore<Integer> n3 = new NoArvore<Integer>(7);

        NoArvore<Integer> n2 = new NoArvore<Integer>(6);

        NoArvore<Integer> n1 = new NoArvore<Integer>(5);

        n1.setPrimeiro(n2);
        n2.setPrimeiro(n3);

        // n3.setProximo(n4);
        arvore2.setRaiz(n1);

        assertTrue(arvore2.isDegenerada());
    }

}
