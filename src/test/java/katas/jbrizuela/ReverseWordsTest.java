package katas.jbrizuela;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class ReverseWordsTest {
    private ReverseWords objeto1;

    @Before
    public void before(){
        objeto1 = new ReverseWords();
    }

    @Test
    public void ejemploUno() { assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", objeto1.reverseWords("The quick brown fox jumps over the lazy dog.")); }

    @Test
    public void ejemploDos() { assertEquals("a b c d", objeto1.reverseWords("a b c d")); }

    @Test
    public void ejemploTres() { assertEquals("a b c d", objeto1.reverseWords("a b c d")); }

    @Test
    public void ejemploCuatro() { assertEquals("elbuod  decaps  sdrow", objeto1.reverseWords("double  spaced  words")); }


}
