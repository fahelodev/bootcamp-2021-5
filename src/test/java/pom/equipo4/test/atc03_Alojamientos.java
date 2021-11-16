package pom.equipo4.test;

import org.junit.Test;
import pom.equipo4.base.TestBase;
import pom.equipo4.pages.VFAlojamientosPage;
import pom.equipo4.pages.VFHomePage;
import pom.equipo4.pages.VFPaquetesPage;
import pom.equipo4.pages.VFTrasladosPage;

public class atc03_Alojamientos extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFAlojamientosPage paginaAlojamientos = null;

    @Test
    public void alojamientoBuscarSegunMejorPuntuacionYMostrarFAQ() throws InterruptedException {
        cargarHome();
        paginaAlojamientos.ingresarDestinoAlojamiento("londres");
        paginaAlojamientos.aplicarBusqueda(true);
        paginaAlojamientos.filtrarMejorPuntuacion();
        paginaAlojamientos.cambiarMoneda();
        paginaAlojamientos.busquedaAlojamiento("The Chelsea Harbour Hotel");
        paginaAlojamientos.mostrarFAQ();
    }

    @Test
    public void alojamientosBuscarMenorAMayorPrecioYConWiFiGratis()
    {
        cargarHome();
    }

    @Test
    public void alojamientosBuscarPrecioMaximoElegirAeropuertoDestinoYAgregarTraslado()
    {
        cargarHome();
    }

    public void cargarHome()
    {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaHome.irSeccionDesdeHome("alojamientos");
        paginaAlojamientos = new VFAlojamientosPage(driver);
    }
}
