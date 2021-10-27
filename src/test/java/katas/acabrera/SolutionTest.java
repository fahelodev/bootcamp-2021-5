package katas.acabrera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void FraseAlReves() {

        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Solution.reverseWords("The quick brown fox jumps over the lazy dog."));

    }

    @Test
    public void palabraAlReves(){
        assertEquals("elppa", Solution.reverseWords("apple"));
    }

    @Test
    public void palabraConEspacio(){

        assertEquals("a b c d", Solution.reverseWords("a b c d"));
    }

    @Test
    public void  fraseConDobleEspacio(){

        assertEquals("elbuod  decaps  sdrow", Solution.reverseWords("double  spaced  words"));

    }
}
