package katas.clopez;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuyCarTest {

    private BuyCar ObjBuyCar;
    @Before
    public void before(){
        ObjBuyCar = new BuyCar();
    }
    @Test
    public void test1() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, ObjBuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void test2() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, ObjBuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }
}