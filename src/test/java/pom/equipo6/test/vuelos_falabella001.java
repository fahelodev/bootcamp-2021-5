package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFHomePage;
import pom.equipo6.pages.VFViajesPage;

public class vuelos_falabella001 extends TestBase {
    protected VFHomePage vfHomePage = null;
    protected VFViajesPage vfViajesPage = null;

    @Test
    public  void Buscar_Vuelo_FechaNoDefinida(){
        vfHomePage = new VFHomePage(driver);
        vfHomePage.goToHomePage();
        vfViajesPage = new VFViajesPage(driver);
        vfViajesPage.goToVuelosPage();
        vfViajesPage.selectOriginCity(VFViajesPage.origins.BuenosAires);
        vfViajesPage.selectDestinationCity(VFViajesPage.destinations.Cordoba);
        vfViajesPage.checkNoDecidatedDate();
        vfViajesPage.clickSearchButton();
    }
}
