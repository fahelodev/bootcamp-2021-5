package katas.jvega;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringUtilsTest {
private StringUtils objeto1;
    @Before
    public void Before() {
        objeto1 = new StringUtils();
    }
    @Test
    public void datoentradaLetra() {
        assertEquals("HELLO WORLD", objeto1.toAlternativeString("hello world"));
        assertEquals("hello world", objeto1.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", objeto1.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", objeto1.toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", objeto1.toAlternativeString(objeto1.toAlternativeString("Hello World")));
        assertEquals("ALTerNAtiNG CaSe", objeto1.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", objeto1.toAlternativeString("ALTerNAtiNG CaSe"));
    }

    @Test
    public void datoentradaNumeroletraSimbolo() {
        assertEquals("12345", objeto1.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", objeto1.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", objeto1.toAlternativeString("StringUtils.toAlternatingCase"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", objeto1.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", objeto1.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
       }



    }

