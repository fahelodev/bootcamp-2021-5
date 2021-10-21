package katas.kmollecundo;

import org.junit.Test;
import static org.junit.Assert.*;

public class alternatingCaseTest {
    @Test
    public void DatoEntradaRetornarMayus() {
        assertEquals("hello world", alternatingCase.toAlternativeString("HELLO WORLD"));
    }
    @Test
    public void DatoEntradaRetornarMinus() {
        assertEquals("HELLO WORLD",alternatingCase.toAlternativeString("hello world"));
    }
    @Test
    public void DatoEntradaRetornarAlternativeMinusMayus(){
        assertEquals("hEllO wOrld", alternatingCase.toAlternativeString("HeLLo WoRLD"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", alternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }
    @Test
    public void DatoEntradaRetornarNumericosNoAlterados(){
        assertEquals("12345", alternatingCase.toAlternativeString("12345"));
    }
    @Test
    public void DatoEntradaRetornarNumericosNoAlteradosMayus(){
        assertEquals("1A2B3C4D5E", alternatingCase.toAlternativeString("1a2b3c4d5e"));
    }

}
