package katas.bbarreto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BuyCarTest {

    private BuyCar objBuyCar;

    @Before
    public void before(){
        objBuyCar = new BuyCar();
    }


    @Test
    public void pruebaAutoUno() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, objBuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }

    @Test
    public void pruebaAutoDos() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, objBuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }
}