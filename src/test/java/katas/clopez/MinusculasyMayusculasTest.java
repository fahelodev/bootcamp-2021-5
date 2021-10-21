package katas.clopez;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinusculasyMayusculasTest {
    // fixedTests()
    @Test
    public void TodoMayusculas(){
        assertEquals("HELLO WORLD", MinusculasyMayusculas.toAlternativeString("hello world"));
    }
    @Test
    public void TodoMinusculas() {
        assertEquals("hello world", MinusculasyMayusculas.toAlternativeString("HELLO WORLD"));
    }
    @Test
    public void PalabrasMinyMay() {
        assertEquals("HELLO world", MinusculasyMayusculas.toAlternativeString("hello WORLD"));
    }
    @Test
    public void SoloVocalesEnMayuscula() {
        assertEquals("hEllO wOrld", MinusculasyMayusculas.toAlternativeString("HeLLo WoRLD"));
    }
    @Test
    public void DobleCiclo() {
        assertEquals("Hello World", MinusculasyMayusculas.toAlternativeString(MinusculasyMayusculas.toAlternativeString("Hello World")));
    }
    @Test
    public void Numeros() {
        assertEquals("12345", MinusculasyMayusculas.toAlternativeString("12345"));
    }
    @Test
    public void NumerosLetras() {
        assertEquals("1A2B3C4D5E", MinusculasyMayusculas.toAlternativeString("1a2b3c4d5e"));
    }
    @Test
    public void MixSimEspacios() {
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", MinusculasyMayusculas.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    //kataTitleTests()
    @Test
    public void Mix1() {
        assertEquals("ALTerNAtiNG CaSe", MinusculasyMayusculas.toAlternativeString("altERnaTIng cAsE"));
    }
    @Test
    public void Mix2() {
        assertEquals("altERnaTIng cAsE", MinusculasyMayusculas.toAlternativeString("ALTerNAtiNG CaSe"));
    }
    @Test
    public void Mix3() {
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", MinusculasyMayusculas.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
    }
    @Test
    public void Mix4(){
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", MinusculasyMayusculas.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}
