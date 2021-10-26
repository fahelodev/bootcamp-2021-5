package junit;

import org.junit.Test;

public class ParametrosTest {

    @Test(expected = ArithmeticException.class)
    public void MatematicaTest(){
        int numero1 = 20;
        int numero2 = 0;
        int divCero = numero1/numero2;
    }

    @Test(timeout = 1200)
    public void testDeTiempoLimite(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
