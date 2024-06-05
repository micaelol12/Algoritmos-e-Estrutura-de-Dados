package exercicio10;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdenacaoTest {
    Integer[] numeros;
    Integer[] numerosOrdenados;

    @BeforeEach
    public void setUp() {
        numeros = new Integer[] { 70, 2, 88, 15, 90, 30 };
        numerosOrdenados = new Integer[] { 2, 15, 30, 70, 88, 90 };
    }

    @Test
    void teste4() {
        OrdenacaoMergeSort<Integer> ordenacao = new OrdenacaoMergeSort<>();

        ordenacao.setInfo(numeros);

        ordenacao.ordenar();

        assertArrayEquals(numerosOrdenados, numeros);

    }
}
