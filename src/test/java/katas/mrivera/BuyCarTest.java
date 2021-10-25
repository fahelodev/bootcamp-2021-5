package katas.mrivera;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BuyCarTest {

    @Test
    public void datoEntradaRetornarSeisMeses() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, BuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void datoEntradaRetornarCeroMeses() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, BuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }
}