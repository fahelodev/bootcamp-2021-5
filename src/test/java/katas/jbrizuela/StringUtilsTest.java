package katas.jbrizuela;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {
private StringUtils objeto1;

    @Before
    public void before(){
        objeto1=new StringUtils();
    }
    @Test
    public void testDeString(){

        assertEquals("HELLO WORLD", objeto1.toAlternativeString("hello world"));
        assertEquals("hello world", objeto1.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", objeto1.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", objeto1.toAlternativeString("HeLLo WoRLD"));
        assertEquals("1A2B3C4D5E", objeto1.toAlternativeString("1a2b3c4d5e"));
        assertEquals("12345", objeto1.toAlternativeString("12345"));
    }

}
