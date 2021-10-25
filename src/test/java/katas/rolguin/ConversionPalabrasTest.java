package katas.rolguin;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionPalabrasTest {


    @Test
    public void tercercaso() {
        assertEquals("a b c d", ConversionPalabras.reverseWords("a b c d"));
    }
    @Test
    public void cuartocaso() {
        assertEquals("elbuod  decaps  sdrow", ConversionPalabras.reverseWords("double  spaced  words"));
    }


    @Test
    public void primercaso() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ConversionPalabras.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void segundocaso() {
        assertEquals("elppa", ConversionPalabras.reverseWords("apple"));

    }

}
