package katas.rolguin;

import org.junit.Test;
import static org.junit.Assert.*;

public class PeleasTest {

    @Test
    public void GanadorPeleador1 (){assertEquals("Peleador 1", Peleas.ElegirGanador(new Peleas.Peleador("Peleador 1",10,2), new Peleas.Peleador("Peleador 2",10,2),"Peleador 1" )); }


    @Test
    public void GanadorPeleador2 (){assertEquals("Peleador 2", Peleas.ElegirGanador(new Peleas.Peleador("Peleador 1",10,2), new Peleas.Peleador("Peleador 2",10,2),"Peleador 2" )); }
}
