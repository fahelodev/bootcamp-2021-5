package katas.foliva;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternatingCaseTest {

    @Test
    public void allLowerCase(){
        assertEquals("HELLO WORLD", StringUtils.toAlternativeString("hello world"));
    }
    @Test
    public void allUpperCase(){
        assertEquals("hello world", StringUtils.toAlternativeString("HELLO WORLD"));
    }
    @Test
    public void oneLowerOneUpper(){
        assertEquals("HELLO world", StringUtils.toAlternativeString("hello WORLD"));
    }
    @Test
    public void allNumbers(){
        assertEquals("12345", StringUtils.toAlternativeString("12345"));
    }
    @Test
    public void twoConvertions(){
        assertEquals("Hello World", StringUtils.toAlternativeString(StringUtils.toAlternativeString("Hello World")));
    }
    @Test
    public void otherCases() {
        assertEquals("hEllO wOrld", StringUtils.toAlternativeString("HeLLo WoRLD"));
        assertEquals("1A2B3C4D5E", StringUtils.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", StringUtils.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", StringUtils.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", StringUtils.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", StringUtils.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", StringUtils.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}
