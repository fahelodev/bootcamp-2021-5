package pom.equipo4.test;

import org.junit.Test;
import pom.equipo4.base.TestBase;
import pom.equipo4.pages.VFHomePage;
import pom.equipo4.pages.VFPaquetesPage;

public class atc03_Alojamientos extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPage paginaPaquetes = null;

    @Test
    public void paquetesBusquedaServiciosYComentarios()
    {
        paginaHome = new VFHomePage(driver);
        //paginaHome.irHome();
        paginaPaquetes = new VFPaquetesPage(driver);
        
    }
}
