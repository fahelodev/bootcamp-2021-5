package katas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests
public class ReverseWordsTest {
        @Test
        public void ejemplo1() {
            assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));
        }
        @Test
        public void ejemplo2() {
            assertEquals("elppa", ReverseWords.reverseWords("apple"));
        }
         @Test
         public void ejemplo3() {
             assertEquals("a b c d", ReverseWords.reverseWords("a b c d"));
         }
         @Test
         public void ejemplo4(){
         assertEquals("elbuod  decaps  sdrow", ReverseWords.reverseWords("double  spaced  words"));
        }
    }
