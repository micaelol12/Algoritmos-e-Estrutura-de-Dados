package Exercicio11;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ListaOrdenadaTest {

    @Test
    void teste1() {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();

        lista.inserir(100);

        lista.inserir(20);

        lista.inserir(70);

        lista.inserir(1);

        assertEquals("1,20,70,100", lista.toString());

    }
}
