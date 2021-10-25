package katas.mcarrillo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FighterKataTest {

    @Test
    public void basicTests() {
        assertEquals("Lew", FighterKata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", FighterKata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", FighterKata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", FighterKata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", FighterKata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", FighterKata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
}
