package katas.kmollecundo;

import org.junit.Test;
import static org.junit.Assert.*;


public class ReverseWordsTest {
    @Test
    public void DatoEntradaRetornarReversa() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.wordReverse("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", ReverseWords.wordReverse("apple"));


    }
    @Test
    public void DatoEntradaRetonarEspacios(){
        assertEquals("a b c d", ReverseWords.wordReverse("a b c d"));
        assertEquals("elbuod  decaps  sdrow", ReverseWords.wordReverse("double  spaced  words"));
    }
}
