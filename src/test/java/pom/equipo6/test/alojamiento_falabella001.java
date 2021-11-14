package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFAlojamientoPage;
import pom.equipo6.pages.VFHomePage;

public class alojamiento_falabella001 extends TestBase {
    protected VFHomePage pageHome = null;
    protected VFAlojamientoPage pageAlojamiento = null;

    @Test
    public void alojamientoFechaNoDefinida(){
        pageHome = new VFHomePage(driver);
        pageHome.goHomePage();
        pageAlojamiento = new VFAlojamientoPage(driver);
        pageAlojamiento.goAlojamientoToHome();
        pageAlojamiento.selectDestino();
        pageAlojamiento.selectNoFecha();
        pageAlojamiento.confirmAlojamiento();
    }
}
