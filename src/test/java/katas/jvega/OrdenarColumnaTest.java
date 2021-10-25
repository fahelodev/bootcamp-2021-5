package katas.jvega;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrdenarColumnaTest {

    private OrdenarColumna objeto;
    @Before
    public void Before(){
      objeto= new OrdenarColumna();
    }

    @Test
    public void entredaConTresFilas() {
        String preSorting = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n"
                + "17945;10091;10088;3907;10132\n"
                + "2;12;13;48;11";
        String postSorting = "Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n"
                + "3907;17945;10091;10088;10132\n"
                + "48;2;12;13;11";
        assertEquals(postSorting, objeto.sortCsvColumns(preSorting));
    }
    @Test
    public void entradaConCuatroFIlas() {
        String preSorting = "IronMan;Thor;Captain America;Hulk\n"
                + "arrogant;divine;honorably;angry\n"
                + "armor;hammer;shield;greenhorn\n"
                + "Tony;Thor;Steven;Bruce";
        String  postSorting = "Captain America;Hulk;IronMan;Thor\n"
                + "honorably;angry;arrogant;divine\n"
                + "shield;greenhorn;armor;hammer\n"
                + "Steven;Bruce;Tony;Thor";
        assertEquals(postSorting, objeto.sortCsvColumns(preSorting));
    }
}
