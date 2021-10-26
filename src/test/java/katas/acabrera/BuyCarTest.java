package katas.acabrera;

import org.junit.*;

import static org.junit.Assert.assertArrayEquals;


public class BuyCarTest {

    private BuyCar objetoBuyCar;


    @BeforeClass
    public static void beforeClass(){

        System.out.println("mostrar el BeforeClass");
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("mostrar el afterClass");
    }

    @Before
    public  void before(){
        objetoBuyCar = new BuyCar();
        System.out.println("mostrar el before");
    }

    @After
    public  void after(){

        System.out.println("mostrar el after");
    }

    @Test
    public void test1() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, objetoBuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void test2() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, objetoBuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }
}
