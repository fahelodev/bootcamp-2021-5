package katas.clopez;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DigPowTest {
    private DigPow ObjDigPow;
    @Before
    public void before(){
        ObjDigPow = new DigPow();
    }

    @Test
    public void Test1() {
        assertEquals(1, ObjDigPow.digPow(89, 1));
    }
    @Test
    public void Test2() {
        assertEquals(-1, ObjDigPow.digPow(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }
}