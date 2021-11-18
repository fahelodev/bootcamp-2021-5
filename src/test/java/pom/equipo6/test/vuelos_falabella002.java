package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFHomePage;
import pom.equipo6.pages.VFViajesPage;

public class vuelos_falabella002 extends TestBase {
    protected VFHomePage vfHomePage = null;
    protected VFViajesPage vfViajesPage = null;

    @Test
    public  void Elegir_VueloIdaMasPasajeros(){
        vfHomePage = new VFHomePage(driver);
        vfHomePage.goToHomePage();
        vfViajesPage = new VFViajesPage(driver);
        vfViajesPage.goToVuelosPage();
        vfViajesPage.checkOneWayFly();
        vfViajesPage.selectOriginCity(VFViajesPage.origins.Cordoba);
        vfViajesPage.selectDestinationCity(VFViajesPage.destinations.Paris);
        vfViajesPage.selectDepartureDay();
        vfViajesPage.clickApplyDatesButton();
        vfViajesPage.settMinorPassengers();
        vfViajesPage.selectFlyClass(VFViajesPage.classFly.premiumEconomy);
        vfViajesPage.clickSearchButton();
    }
}
