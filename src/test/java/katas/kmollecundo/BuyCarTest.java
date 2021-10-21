package katas.kmollecundo;

import org.junit.*;
import static org.junit.Assert.*;


public class BuyCarTest {
    private BuyCar Car;
    @BeforeClass
    public static void beforeClass(){

        System.out.println("beforeClass()");

    }
    @Before
    public void before(){
        Car = new BuyCar();
        System.out.println("before()");
    }
    @Test
    public void DatoEntradaRetornarConAhorro(){
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, Car.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void DatoEntradaRetornarSinAhorro(){
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, Car.nbMonths(12000, 8000, 1000, 1.5));
    }
    @After
    public void after(){
        System.out.println("after()");
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("afterClass()");

    }
}
