package katas.clopez;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseTest {
    @Test
    public void GirarUnaPalabra(){
        assertEquals("elppa", Reverse.ReverseWords("apple"));
    }

    @Test
    public void GirarPalabrasDeUnaFrase() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Reverse.ReverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void Letras(){
        assertEquals("a b c d", Reverse.ReverseWords("a b c d"));
    }

    @Test
    public void Espacios(){
        assertEquals("elbuod  decaps  sdrow", Reverse.ReverseWords("double  spaced  words"));
    }
}
