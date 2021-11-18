package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFAlojamientoPage;
import pom.equipo6.pages.VFHomePage;

public class alojamiento_falabella002 extends TestBase {
    protected VFHomePage pageHome = null;
    protected VFAlojamientoPage pageAlojamiento = null;

    @Test
    public void alojamientoSegundoFechaNoDefinida(){
        pageHome = new VFHomePage(driver);
        pageHome.goToHomePage();
        pageAlojamiento = new VFAlojamientoPage(driver);
        pageAlojamiento.goAlojamientoToHome();
        pageAlojamiento.selectDestino();
        pageAlojamiento.confirmFechaAlojamiento();
        pageAlojamiento.confirmAlojamiento();
        pageAlojamiento.otherAlojamiento();
        pageAlojamiento.selectSecondNoFecha();
        pageAlojamiento.confirmSecondAlojamiento();
        pageAlojamiento.checkText002();
    }
}
