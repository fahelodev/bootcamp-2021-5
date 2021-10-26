package katas.jspizarro;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigPowTest {
    @Test
    public void existeEntero() {
        assertEquals(1, DigPow.digPow(89, 1));
    }
    @Test
    public void noExisteEntero() {
        assertEquals(-1, DigPow.digPow(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }


}
