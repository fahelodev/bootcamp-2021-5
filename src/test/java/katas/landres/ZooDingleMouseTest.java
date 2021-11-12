package katas.landres;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZooDingleMouseTest {
    private ZooDingleMouse objeto;


    @Before
    public void Before(){
        objeto= new ZooDingleMouse();
    }

    @Test
    public void testPrueba1() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, objeto.whoEatsWho(input));
    }
}