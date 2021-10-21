package katas.clopez;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PeleaTest {
    @Test
    public void Pelea1() {
        assertEquals("Lew", Pelea.declararGanador(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));
    }
    @Test
    public void Pelea2() {
        assertEquals("Harry", Pelea.declararGanador(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry"));
    }
    @Test
    public void Pelea3() {
        assertEquals("Harald", Pelea.declararGanador(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
    }
    @Test
    public void Pelea4() {
        assertEquals("Harald", Pelea.declararGanador(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
    }
    @Test
    public void Pelea5() {
        assertEquals("Harald", Pelea.declararGanador(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
    }
    @Test
    public void Pelea6() {
        assertEquals("Harald", Pelea.declararGanador(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
}
