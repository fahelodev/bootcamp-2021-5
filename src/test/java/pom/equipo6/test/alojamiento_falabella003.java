package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFAlojamientoPage;
import pom.equipo6.pages.VFHomePage;

public class alojamiento_falabella003 extends TestBase {
    protected VFHomePage pageHome = null;
    protected VFAlojamientoPage pageAlojamiento = null;

    @Test
    public void alojamientoHotelConReservaAeroPuerto() throws InterruptedException {
        pageHome = new VFHomePage(driver);
        pageHome.goToHomePage();
        pageAlojamiento = new VFAlojamientoPage(driver);
        pageAlojamiento.goAlojamientoToHome();
        pageAlojamiento.selectHotel();
        pageAlojamiento.confirmFechaHotel();
        pageAlojamiento.confirmSecondHotel();
        pageAlojamiento.confirmReservaSecondHotel();
        pageAlojamiento.confirmAeroPuerto();
        pageAlojamiento.confirmTraslado();
        pageAlojamiento.checkText003();
    }
}
