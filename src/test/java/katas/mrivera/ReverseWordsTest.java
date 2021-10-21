package katas.mrivera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

        @Test
        public void datoEntradaValoresAlfanumericos() {
            assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));
        }

        @Test
        public void datoEntradaUnaPalabra(){
            assertEquals("elppa", ReverseWords.reverseWords("apple"));
        }

        @Test
        public void datoEntradaSoloLetras(){
            assertEquals("a b c d", ReverseWords.reverseWords("a b c d"));
        }

        @Test
        public void datoEntradaDobleEspacios(){
            assertEquals("elbuod  decaps  sdrow", ReverseWords.reverseWords("double  spaced  words"));

        }

}
