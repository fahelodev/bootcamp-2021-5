package katas.rolguin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArchivoCSVTest {
    private ArchivoCSV objCSV;

    @Before
    public void before(){
        objCSV = new ArchivoCSV();
    }

    @Test
    public void ordenamientoCorrecto(){
        String resultado=objCSV.ordenamientoCSV("myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n" +
                "17945;10091;10088;3907;10132\n" +
                "2;12;13;48;11");
        String resultadoEsperado="Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n" +
                "3907;17945;10091;10088;10132\n" +
                "48;2;12;13;11";
        assertEquals(resultadoEsperado,resultado);
    }
}
