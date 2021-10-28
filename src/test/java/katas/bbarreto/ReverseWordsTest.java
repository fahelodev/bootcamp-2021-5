package katas.bbarreto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

    @Test
    public void ejemploUno() { assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KatasReverseWords.reverseWords("The quick brown fox jumps over the lazy dog.")); }

    @Test
    public void ejemploDos() { assertEquals("elppa", KatasReverseWords.reverseWords("apple")); }

    @Test
    public void ejemploTres() { assertEquals("a b c d", KatasReverseWords.reverseWords("a b c d")); }

    @Test
    public void ejemploCuatro() { assertEquals("elbuod  decaps  sdrow", KatasReverseWords.reverseWords("double  spaced  words")); }

}