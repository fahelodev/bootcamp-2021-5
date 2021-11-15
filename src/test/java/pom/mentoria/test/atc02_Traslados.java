package pom.mentoria.test;

import org.junit.Test;
import pom.mentoria.base.TestBase;
import pom.mentoria.pages.VFHomePage;
import pom.mentoria.pages.VFPaquetesPage;

public class atc02_Traslados extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPage paginaPaquetes = null;

    @Test
    public void trasladosBusquedaYMostrarMapa()
    {
        paginaHome = new VFHomePage(driver);
        //paginaHome.irHome();
        paginaPaquetes = new VFPaquetesPage(driver);
        
    }

    @Test
    public void trasladosBusquedaCambioHoraYMoneda()
    {

    }

    @Test
    public void trasladosBusquedaValidarCanjePuntosYFormasPago()
    {

    }
}
