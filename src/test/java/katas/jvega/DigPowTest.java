package katas.jvega;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigPowTest {
    private DigPow objeto1;
    @Before
    public void Before(){
        objeto1=new DigPow();

    }

    @Test
    public void datoEntradaRetornaError() {
        assertEquals(-1, objeto1.digPow(92, 1));
    }
    @Test
    public void datoEntradaRetornak() {
        assertEquals(1, objeto1.digPow(89, 1));
         assertEquals(51, objeto1.digPow(46288, 3));
         assertEquals(2, objeto1.digPow(695, 2));
    }

}
