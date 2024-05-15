package exercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class MapaDispersaoTest {

    @Test
    public void test1() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));

        mapa.inserir(obj1.getMatricula(), obj1);

        assertEquals(obj1, mapa.buscar(12000));
    }

    @Test
    public void test2() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno obj4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(obj1.getMatricula(), obj1);
        mapa.inserir(obj2.getMatricula(), obj2);
        mapa.inserir(obj3.getMatricula(), obj3);
        mapa.inserir(obj4.getMatricula(), obj4);

        assertEquals(obj1, mapa.buscar(12000));
        assertEquals(obj2, mapa.buscar(14000));
        assertEquals(obj3, mapa.buscar(12500));
        assertEquals(obj4, mapa.buscar(13000));
    }

    @Test
    public void test3() {
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno obj3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno obj4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(obj1.getMatricula(), obj1);
        mapa.inserir(obj2.getMatricula(), obj2);
        mapa.inserir(obj3.getMatricula(), obj3);
        mapa.inserir(obj4.getMatricula(), obj4);

        assertEquals(obj1, mapa.buscar(12000));
        assertEquals(obj2, mapa.buscar(14000));
        assertEquals(obj3, mapa.buscar(14226));
        assertEquals(obj4, mapa.buscar(17180));
    }
}
