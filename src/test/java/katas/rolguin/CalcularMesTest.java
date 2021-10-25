package katas.rolguin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class CalcularMesTest {

    private CalcularMes objCalcularMes;

    @Before
    public void before(){
        objCalcularMes = new CalcularMes();
    }

    @Test
    public void testCalcular6Meses(){

        int [] resultadoEsperado = new int[] { 6,766 };
        assertArrayEquals(resultadoEsperado,objCalcularMes.CalcularCompra(2000, 8000,1000,1.5));
    }

    @Test
    public void testCalcular8Meses(){
        int [] resultadoEsperado=  new int []{8, 597};
        assertArrayEquals(resultadoEsperado,objCalcularMes.CalcularCompra(8000, 12000, 500, 1.0));
    }

    @Test
    public void testCalcular25Meses(){
        int [] resultadoEsperado=  new int []{25, 121};
        assertArrayEquals(resultadoEsperado,objCalcularMes.CalcularCompra(7500, 32000, 300, 1.55));
    }

    @After
    public void after(){
        System.out.println("Test Finalizado");
    }



}
