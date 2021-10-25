package katas.rolguin;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlternandoCaseTest {
    @Test
    public void MinusculaaMayuscula (){assertEquals("HELLO WORLD",AlternandoCase.ConvertirLetras("hello world"));  }

    @Test
    public void MayusculaaMinuscula (){assertEquals("hello world",AlternandoCase.ConvertirLetras("HELLO WORLD"));  }

    @Test
    public void MayusMinus1 (){assertEquals("HELLO world",AlternandoCase.ConvertirLetras("hello WORLD"));  }

    @Test
    public void MayusMinus2 (){assertEquals("hEllO wOrld",AlternandoCase.ConvertirLetras("HeLLo WoRLD"));  }

    @Test
    public void Numeros  (){assertEquals("12345",AlternandoCase.ConvertirLetras("12345"));  }

    @Test
    public void NumerosyLetras  (){assertEquals("1a2b3c4d5e",AlternandoCase.ConvertirLetras("1A2B3C4D5E"));  }

    @Test
    public void OracionConPunto  (){assertEquals("sTRINGuTILS.TOaLTERNATINGcASE",AlternandoCase.ConvertirLetras("StringUtils.toAlternatingCase"));  }
}
