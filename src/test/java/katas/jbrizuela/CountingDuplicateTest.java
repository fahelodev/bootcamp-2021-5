package katas.jbrizuela;

import katas.CountingDuplicates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountingDuplicateTest {
    private CountingDuplicates objeto1;

    @Before
    public void before(){
        objeto1 = new CountingDuplicates();

    }


    @Test
    public void datoEntradaRetornarCero(){
        assertEquals(0,objeto1.duplicateCount("abcde"));
    }

    @Test
    public void datoEntradaRetornaDos(){
        assertEquals(2, objeto1.duplicateCount("aabbcde"));
    }

    @Test
    public void datoEntradaRetornaDosCaseSensitive(){
        assertEquals(2, objeto1.duplicateCount("aabBcde"));
    }
    @Test
    public void datoEntradaLimiteAlfabetico() {
        assertEquals(-1, objeto1.duplicateCount("##aabb%%^^"));
    }

    @Test
    public void datoEntradaretornaUno() {
        assertEquals(1, objeto1.duplicateCount("iiiiii"));
    }

}
