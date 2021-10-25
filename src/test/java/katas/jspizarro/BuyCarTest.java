package katas.jspizarro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BuyCarTest {
    private BuyCar objeto1;

    @Before
    public void before(){
        objeto1 = new BuyCar();
    }

    @Test
    public void precioNuevoMayor() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, objeto1.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void precioViejoMayor() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, objeto1.nbMonths(12000, 8000, 1000, 1.5));
    }
    @Test
    public void preciosIguales() {
        int[] r = new int[] { 0, 0 };
        assertArrayEquals(r, objeto1.nbMonths(8000, 8000, 1000, 1.5));
    }

}
