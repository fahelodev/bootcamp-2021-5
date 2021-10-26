package katas.gortego;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class ReverseWordsTest {


    @Test
        public void ejemplo1() { assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KatasReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));}
    @Test
        public void ejemplo2() {assertEquals("elppa", KatasReverseWords.reverseWords("apple"));}
    @Test
        public void ejemplo3() {assertEquals("a b c d", KatasReverseWords.reverseWords("a b c d"));}
    @Test
        public void ejemplo4() {assertEquals("elbuod  decaps  sdrow", KatasReverseWords.reverseWords("double  spaced  words"));}

    @Test
    public void ejemplo5() {assertEquals("   ", KatasReverseWords.reverseWords("   "));}
    }


