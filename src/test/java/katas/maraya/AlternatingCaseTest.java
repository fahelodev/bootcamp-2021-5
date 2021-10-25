package katas.maraya;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternatingCaseTest {



    @Test
    public void datoEntradaCadenaMayuscula() {
        assertEquals("HELLO WORLD", AlternatingCase.toAlternativeString("hello world"));


    }
    @Test
    public void datoEntradaCadenaMinuscula() {
        assertEquals("hello world", AlternatingCase.toAlternativeString("HELLO WORLD"));


    }
    @Test
    public void datoEntradaCadenaMayusculayMinuscula() {

        assertEquals("HELLO world", AlternatingCase.toAlternativeString("hello WORLD"));

    }
    @Test
    public void datoEntradaCadenaMayusculasEntreMinusculas() {
        assertEquals("hEllO wOrld", AlternatingCase.toAlternativeString("HeLLo WoRLD"));


    }
    @Test
    public void datoEntradaCadenaMayusculaAlPrincipioDePalabra() {
        assertEquals("Hello World", AlternatingCase.toAlternativeString(AlternatingCase.toAlternativeString("Hello World")));


    }
    @Test
    public void datoEntradaCadenaTextoNumero() {
        assertEquals("12345", AlternatingCase.toAlternativeString("12345"));


    }
    @Test
    public void datoEntradaCadenaLetrasyNumeros() {

        assertEquals("1A2B3C4D5E", AlternatingCase.toAlternativeString("1a2b3c4d5e"));

    }
    @Test
    public void datoEntradaCadenaMayusculasyMinusculasAlternadas() {

        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));

    }



    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", AlternatingCase.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", AlternatingCase.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}