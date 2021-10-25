package katas.foliva;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class reverseWordsTest {
    @Test
    public void longText(){
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords.reverseWordsFn("The quick brown fox jumps over the lazy dog."));
    }
    @Test
    public void singleWord(){
        assertEquals("elppa", reverseWords.reverseWordsFn("apple"));
    }
    @Test
    public void singleChars(){
        assertEquals("a b c d", reverseWords.reverseWordsFn("a b c d"));
    }
    @Test
    public void doubleSpace(){
            assertEquals("elbuod  decaps   sdrow", reverseWords.reverseWordsFn("double  spaced   words"));
    }
    @Test
    public void randomTest(){
        assertEquals("dluohs   !elur   [sihT]", reverseWords.reverseWordsFn("should   rule!   ]This["));
    }
}