package katas.mrivera;

import static org.junit.Assert.*;
import org.junit.Test;


public class DigPowTest {

    @Test
    public void retornarUno() {
        assertEquals(1, DigPow.digPow(89, 1));
    }
    @Test
    public void retornarNoEncontrado() {
        assertEquals(-1, DigPow.digPow(92, 1));
    }
    @Test
    public void retornarCincuentaYUno() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }
}
