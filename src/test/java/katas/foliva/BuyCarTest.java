package katas.foliva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BuyCarTest {

    private BuyCar buyCarObj;

    @Before
    public void before(){
        buyCarObj = new BuyCar();
    }

    @Test
    public void initialOldPriceIsSmaller() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, buyCarObj.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void initialOldPriceIsBigger() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, buyCarObj.nbMonths(12000, 8000, 1000, 1.5));
    }
}