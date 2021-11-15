package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFHomePage;
import pom.equipo6.pages.VFPaquetesPage;

public class paquetes_falabella002 extends TestBase {
    protected VFHomePage pageHome = null;
    protected VFPaquetesPage pagePaquetes = null;

    @Test
    public void paqueteCompletoBuscandoMenorCosto(){
        pageHome = new VFHomePage(driver);
        pageHome.goHomePage();
        pagePaquetes = new VFPaquetesPage(driver);
        pagePaquetes.goPaquetesToHome();
        pagePaquetes.selectCiudadOrigen();
        pagePaquetes.selectCiudadDestino();
        pagePaquetes.defineFechaPaquete();
        pagePaquetes.addAdultAndChildHabitaciones();
        pagePaquetes.applySearch();
        pagePaquetes.orderByMenorCosto();
        pagePaquetes.checkText002();
    }
}
