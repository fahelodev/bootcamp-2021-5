package pom.mentoria.test;

import org.junit.Test;
import pom.mentoria.base.TestBase;
import pom.mentoria.pages.VFHomePage;
import pom.mentoria.pages.VFPaquetesPage;

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
