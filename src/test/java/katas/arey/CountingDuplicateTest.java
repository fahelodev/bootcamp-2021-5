package katas.arey;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountingDuplicateTest {

    @Test
    public void datoEntradaRetornarCero(){
        Assert.assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void datoEntradaRetornaDos(){
        assertEquals(2, CountingDuplicates.duplicateCount("aabbcde"));
    }

    @Test
    public void datoEntradaRetornaDosCaseSensitive(){
        assertEquals(2, CountingDuplicates.duplicateCount("aabBcde"));
    }
    @Test
    public void datoEntradaLimiteAlfabetico() {
        assertEquals(-1, CountingDuplicates.duplicateCount("##aabb%%^^"));
    }

    @Test
    public void datoEntradaretornaUno() {
        assertEquals(1, CountingDuplicates.duplicateCount("iiiiii"));
    }

}
