package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFHomePage;
import pom.equipo6.pages.VFViajesPage;

public class vuelos_falabella003 extends TestBase {
    protected VFHomePage vfHomePage = null;
    protected VFViajesPage vfViajesPage = null;

    @Test
    public  void Realizar_Vuelo_checkout(){
        vfHomePage = new VFHomePage(driver);
        vfHomePage.goToHomePage();
        vfViajesPage = new VFViajesPage(driver);
        vfViajesPage.goToVuelosPage();
        vfViajesPage.selectOriginCity(VFViajesPage.origins.BuenosAires);
        vfViajesPage.selectDestinationCity(VFViajesPage.destinations.Londres);
        vfViajesPage.selectDepartureDay();
        vfViajesPage.selectArrivalDay();
        vfViajesPage.clickApplyDatesButton();
        vfViajesPage.settMinorPassengers();
        vfViajesPage.selectFlyClass(VFViajesPage.classFly.ejecutivaBusiness);
        vfViajesPage.clickSearchButton();
        vfViajesPage.filterByScale();
        vfViajesPage.filterByBaggage();
        vfViajesPage.filterByCurrency();
        vfViajesPage.filterByOrder();
        vfViajesPage.clickSelectButton();
    }
}
