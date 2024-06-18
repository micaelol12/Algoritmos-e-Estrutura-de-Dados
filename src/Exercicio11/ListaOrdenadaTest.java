package Exercicio11;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ListaOrdenadaTest {

    ListaOrdenada<Integer> l;

    @Before
    public void init(){
        l = new ListaOrdenada<>();
    }

    @Test
    public void TestarInserir(){
        l.inserir(100);
        l.inserir(20);
        l.inserir(70);
        l.inserir(1);

        assertEquals("1,20,70,100", l.toString());
    }

    @Test
    public void BuscarTeste(){
        for (int i = 0; i < 110; i += 10) {
            l.inserir(i);
        }

        assertEquals(2, l.buscar(20));
    }

    @Test
    public void BuscarDnvTeste(){
        for (int i = 0; i <= 110; i += 10) {
            l.inserir(i);
        }

        assertEquals(4, l.buscar(40));
    }

    @Test
    public void BuscarDnvDnvTeste(){
        for (int i = 0; i <= 110; i += 10) {
            l.inserir(i);
        }

        assertEquals(7, l.buscar(70));
    }

    @Test
    public void BuscarDnvDnvDnvTeste(){
        for (int i = 0; i <= 110; i += 10) {
            l.inserir(i);
        }

        assertEquals(10, l.buscar(100));
    }

    @Test
    public void BuscarDnvDnvDnvDnvTeste(){
        for (int i = 0; i <= 110; i += 10) {
            l.inserir(i);
        }

        assertEquals(-1, l.buscar(85));
    }
}
