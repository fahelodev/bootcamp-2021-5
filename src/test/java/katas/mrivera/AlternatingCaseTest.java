package katas.mrivera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternatingCaseTest {


    @Test
    public void datoEntradaRetornarTodoMinuscula(){
        assertEquals("HELLO WORLD", AlternatingCase.toAlternativeString("hello world"));
    }

    @Test
    public void datoEntradaRetornarTodoMayuscula(){
        assertEquals("hello world", AlternatingCase.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void datoEntradaRetornarMinusculaYMayuscula(){
        assertEquals("HELLO world", AlternatingCase.toAlternativeString("hello WORLD"));
    }

    @Test
    public void datoEntradaCaracteresVariados(){
        assertEquals("hEllO wOrld", AlternatingCase.toAlternativeString("HeLLo WoRLD"));
    }

    @Test
    public void datoEntradaRetornarPalabrasCapitalizadas(){
        assertEquals("Hello World", AlternatingCase.toAlternativeString(AlternatingCase.toAlternativeString("Hello World")));
    }

    @Test
    public void datoEntradaRetornarNumeros(){
        assertEquals("12345", AlternatingCase.toAlternativeString("12345"));
    }

    @Test
    public void datoEntradaAlfanumericos(){
        assertEquals("1A2B3C4D5E", AlternatingCase.toAlternativeString("1a2b3c4d5e"));
    }

    @Test
    public void dataEntradaSimbolos() {
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }

}