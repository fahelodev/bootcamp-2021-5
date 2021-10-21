package katas.kmollecundo;

import org.junit.Test;
import static org.junit.Assert.*;


public class twoFightersOneWinnerTest {
    @Test
    public void DatoEntradaRetonarHarryVsLew(){
        assertEquals("Lew", twoFightersOneWinner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
    }
    @Test
    public void DatoEntradaRetornarLewVsHarry(){
        assertEquals("Harry", twoFightersOneWinner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));

    }
    @Test
    public void DatoEntradaRetornarHaraldVsHarry(){
        assertEquals("Harald", twoFightersOneWinner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));

    }
    @Test
    public void DatoEntradaRetornarHarryVsHarald(){
        assertEquals("Harald", twoFightersOneWinner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));

    }
    @Test
    public void DatoEntradaRetornarHaraldVsJerry(){
        assertEquals("Harald", twoFightersOneWinner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));

    }
    @Test
    public void DatoEntradaRetornarJerryVsHarald(){
        assertEquals("Harald", twoFightersOneWinner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));

    }

}
