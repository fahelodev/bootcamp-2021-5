package katas.jvega;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoFighterTest {

    private Fighter objeto;
    @Before
    public void Before(){
     objeto = new Fighter();
    }
    @Test
    public void primerPeleadorPegaprimero() {
        assertEquals("Lew", objeto.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harald", objeto.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));

    }
    @Test
    public void segundoPeleadorPegaPrimero() {
        assertEquals("Harald", objeto.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harry", objeto.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", objeto.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }


}
