package katas.arey;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {
    // Asi tambien se puede hacer
    /*@Test
    public void CasosPrueba() {
        assertEquals("aloh",ReverseWords.reverseWords("hola"));
        assertEquals("uahc",ReverseWords.reverseWords("chau"));
    }*/

    @Test
    public void datoEntradaRetornaStringRevesSignosOrtograficos() {
        assertEquals(",aloh odot ?neib", ReverseWords.reverseWords("hola, todo bien?"));
    }

    @Test
    public void datoEntradaRetornaStringReves() {
        assertEquals("aloh",ReverseWords.reverseWords("hola"));
    }

    @Test
    public void datoEntradaRetornaStringRevesEspacios() {
        assertEquals("h o l a",ReverseWords.reverseWords("h o l a"));
    }

    @Test
    public void datoEntradaRetornaStringRevesDobleEspacio() {
        assertEquals("aloh  omoc  satse",ReverseWords.reverseWords("hola  como  estas"));
    }

}
