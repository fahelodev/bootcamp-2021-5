package katas.landres;

import org.junit.*;

import static org.junit.Assert.assertArrayEquals;

public class BuyCarTest {

    private BuyCar objBuycar;
    @BeforeClass
    public static void beforeClass(){

        System.out.println("beforeClass pruebas()");
            }

    @AfterClass
    public static void afterClass(){

        System.out.println("afterClasss()");
    }

    @Before
    public void before(){
        System.out.println("before()");
        objBuycar = new BuyCar();}

    @After
    public void after(){
        System.out.println("after()");
    }

    @Test
    public void RESTANTE() {
        System.out.println("Se ejecuta prueba1");
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, objBuycar.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void RESTANTE2() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, objBuycar.nbMonths(12000, 8000, 1000, 1.5));
    }
}