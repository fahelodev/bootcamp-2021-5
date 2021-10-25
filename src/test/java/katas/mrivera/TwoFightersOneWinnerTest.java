package katas.mrivera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoFightersOneWinnerTest {

    @Test
    public void datoEntradaPrimerPeleadorEmpiezaYGana(){
        assertEquals("Harald", TwoFightersOneWinner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
    }

    @Test
    public void datoEntradaPrimerPeleadorEmpiezaYPierde(){
        assertEquals("Harald", TwoFightersOneWinner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
    }

    @Test
    public void datoEntradaSegundoPeleadorEmpiezaYGana(){
        assertEquals("Harry", TwoFightersOneWinner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
    }

    @Test
    public void datoEntradaSegundoPeleadorEmpiezaYPierde(){
        assertEquals("Jerry", TwoFightersOneWinner.declareWinner(new Fighter("Jerry", 30, 5), new Fighter("Harald", 20, 5), "Harald"));
    }


}
