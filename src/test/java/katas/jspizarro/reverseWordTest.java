package katas.jspizarro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class reverseWordTest {


//TODO: Replace examples and use TDD development by writing your own tests

    @Test
    public void exampleCases1() {assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", kataReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));}
    @Test
    public void exampleCases2() {assertEquals("elppa", kataReverseWords.reverseWords("apple"));}
    @Test
    public void exampleCases3() {assertEquals("a b c d", kataReverseWords.reverseWords("a b c d"));}
    @Test
    public void exampleCases4() {assertEquals("elbuod  decaps  sdrow", kataReverseWords.reverseWords("double  spaced  words"));}
    @Test
    public void exampleCases5() {assertEquals("   ",kataReverseWords.reverseWords("   "));}

}
