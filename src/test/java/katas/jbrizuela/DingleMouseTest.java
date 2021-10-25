package katas.jbrizuela;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DingleMouseTest {

    @Test
    public void example() {
            final String input = "fox,bug,chicken,grass,sheep";
            final String[] expected = 	{
                    "fox,bug,chicken,grass,sheep",
                    "chicken eats bug",
                    "fox eats chicken",
                    "sheep eats grass",
                    "fox eats sheep",
                    "fox"};
            assertArrayEquals(expected, DingleMouse.whoEatsWho(input));
        }

}
