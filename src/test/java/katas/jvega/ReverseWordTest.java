package katas.jvega;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordTest {
    private ReverseWord objeto;
    @Before
    public void Before(){
        objeto=new ReverseWord();
    }

    @Test
    public void entradaDatoUnEspacio() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", objeto.wordReverse("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void entradaDatoSinEspacio() {
        assertEquals("elppa", objeto.wordReverse("apple"));
    }

    @Test
    public void entradaDatoLetraEspacio() {
        assertEquals("a b c d", objeto.wordReverse("a b c d"));
    }


    @Test
    public void entradaDatoDosEspacio() {
        assertEquals("elbuod  decaps  sdrow", objeto.wordReverse("double  spaced  words"));
    }

}