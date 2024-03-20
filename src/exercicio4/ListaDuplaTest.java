package exercicio4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaDuplaTest {

    ListaDupla<Integer> numeros = new ListaDupla<>();

    @BeforeEach
    public void setUp() {
        numeros.inserir(5);
        numeros.inserir(10);
        numeros.inserir(15);
        numeros.inserir(20);

    }

    @Test
    void test1() {
        NoListaDupla<Integer> p = numeros.getPrimeiro();

        assertEquals(p.getInfo(), 20);

        p = p.getProximo();

        assertEquals(p.getInfo(), 15);

        p = p.getProximo();

        assertEquals(p.getInfo(), 10);

        p = p.getProximo();

        assertEquals(p.getInfo(), 5);

    }

    @Test
    void test2() {
        assertEquals(numeros.buscar(20).getInfo(), 20);
    };

    @Test
    void test3() {
        assertEquals(numeros.buscar(10).getInfo(), 10);
    };

    @Test
    void test4() {

        numeros.retirar(20);

        NoListaDupla<Integer> p = numeros.getPrimeiro();

        assertEquals(p.getAnterior(), null);

        assertEquals(p.getInfo(), 15);

        p = p.getProximo();

        assertEquals(p.getInfo(), 10);

        p = p.getProximo();

        assertEquals(p.getInfo(), 5);

    };

    @Test
    void test5() {

        numeros.retirar(10);

        NoListaDupla<Integer> p = numeros.getPrimeiro();

        assertEquals(p.getInfo(), 20);

        p = p.getProximo();

        assertEquals(p.getInfo(), 15);

        p = p.getProximo();

        assertEquals(p.getInfo(), 5);

    };

    @Test
    void test6() {

        numeros.retirar(5);

        NoListaDupla<Integer> p = numeros.getPrimeiro();

        assertEquals(p.getInfo(), 20);

        p = p.getProximo();

        assertEquals(p.getInfo(), 15);

        p = p.getProximo();

        assertEquals(p.getInfo(), 10);

        assertEquals(p.getProximo(), null);

    };

    @Test
    void test7() {

        NoListaDupla<Integer> aux5 = numeros.buscar(5);
        NoListaDupla<Integer> aux10 = numeros.buscar(10);
        NoListaDupla<Integer> aux15 = numeros.buscar(15);
        NoListaDupla<Integer> aux20 = numeros.buscar(20);

        numeros.liberar();

        assertEquals(null, aux5.getAnterior());
        assertEquals(null, aux5.getProximo());

        assertEquals(null, aux10.getAnterior());
        assertEquals(null, aux10.getProximo());

        assertEquals(null, aux15.getAnterior());
        assertEquals(null, aux15.getProximo());

        assertEquals(null, aux20.getAnterior());
        assertEquals(null, aux20.getProximo());

    };

}
