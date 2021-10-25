package katas.mrivera;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DinglemouseTest {
    Dinglemouse dinglemouse;

    @Before
    public void before(){
        dinglemouse = new Dinglemouse();
    }

    @Test
    public void soloQuedaUnAnimal() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, dinglemouse.whoEatsWho(input));
    }
    @Test
    public void unSuceso(){
        final String input = "cow,lion,sheep,chicken,busker,sheep,giraffe";
        final String[] expected = {
                "cow,lion,sheep,chicken,busker,sheep,giraffe",
                "lion eats cow",
                "lion,sheep,chicken,busker,sheep,giraffe"
        };
        assertArrayEquals(expected, dinglemouse.whoEatsWho(input));

    }

    @Test
    public void dosSucesos(){
        final String input = "chicken,bear,grass,antelope,giraffe,big-fish";
        final String[] expected = {
                "chicken,bear,grass,antelope,giraffe,big-fish",
                "bear eats chicken",
                "antelope eats grass",
                "bear,antelope,giraffe,big-fish"
        };
        assertArrayEquals(expected, dinglemouse.whoEatsWho(input));

    }

    @Test
    public void conElementosInanimados(){
        final String input = "lion,bicycle,bear,bicycle,big-fish,bear,little-fish,panda";
        final String[] expected = {
                "lion,bicycle,bear,bicycle,big-fish,bear,little-fish,panda",
                "bear eats big-fish",
                "lion,bicycle,bear,bicycle,bear,little-fish,panda"
        };
        assertArrayEquals(expected, dinglemouse.whoEatsWho(input));

    }


}
