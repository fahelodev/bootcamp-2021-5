package katas.foliva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZooDisasterTest {

    private ZooDisaster zooDisaster;
    @Before
    public void before(){
        zooDisaster = new ZooDisaster();
    }
    @Test
    public void foodChainAnimal() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, zooDisaster.whoEatsWho(input));
    }

}
