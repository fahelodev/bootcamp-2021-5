package pom.equipo6.test;

import org.junit.Test;
import pom.equipo6.base.TestBase;
import pom.equipo6.pages.VFHomePage;
import pom.equipo6.pages.VFPaquetesPage;

public class paquetes_falabella001 extends TestBase {
    protected VFHomePage pageHome = null;
    protected VFPaquetesPage pagePaquetes = null;

    @Test
    public void paqueteSinFechaDefinida(){
        pageHome = new VFHomePage(driver);
        pageHome.goToHomePage();
        pagePaquetes = new VFPaquetesPage(driver);
        pagePaquetes.goPaquetesToHome();
        pagePaquetes.selectCiudadOrigen();
        pagePaquetes.selectCiudadDestino();
        pagePaquetes.selectNoFecha();
        pagePaquetes.applySearch();
        pagePaquetes.checkText001();
    }
}
