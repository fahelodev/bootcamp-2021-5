package katas.jspizarro;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringUtilsTest {
    @Test
    public void lowercaseBecomeUppercase(){assertEquals("HELLO WORLD", StringUtils.toAlternativeString("hello world"));}
    @Test
    public void uppercaseBecomeLowercase(){assertEquals("hello world", StringUtils.toAlternativeString("HELLO WORLD"));}
    @Test
    public void uppercaseAndLowercaseWords(){assertEquals("HELLO world", StringUtils.toAlternativeString("hello WORLD"));}
    @Test
    public void uppercaseAndLowercase(){assertEquals("hEllO wOrld", StringUtils.toAlternativeString("HeLLo WoRLD"));}
    @Test
    public void uppercaseAndLowercase2(){assertEquals("Hello World", StringUtils.toAlternativeString(StringUtils.toAlternativeString("Hello World")));}
    @Test
    public void numbers(){assertEquals("12345", StringUtils.toAlternativeString("12345"));}
    @Test
    public void numbersAndLetters(){assertEquals("1A2B3C4D5E", StringUtils.toAlternativeString("1a2b3c4d5e"));}
    @Test
    public void lettersAndCharacters(){assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", StringUtils.toAlternativeString("StringUtils.toAlternatingCase"));}

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", StringUtils.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", StringUtils.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", StringUtils.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", StringUtils.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }



}
