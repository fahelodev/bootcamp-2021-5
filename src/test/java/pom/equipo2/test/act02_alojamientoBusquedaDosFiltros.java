package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFAlojamientoPage;
import pom.equipo2.pages.VFBusquedaAlojamientoPage;
import pom.equipo2.pages.VFHomePage;


public class act02_alojamientoBusquedaDosFiltros extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;
    protected VFBusquedaAlojamientoPage paginaBusquedaAlojamiento = null;

    @Test
    public void act02_alojamientoBusquedaDosFiltros(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.cargarDestino();
        paginaAlojamiento.cargarFechas();
        paginaAlojamiento.confirmarBusqueda();
        paginaBusquedaAlojamiento = new VFBusquedaAlojamientoPage(driver);
        paginaBusquedaAlojamiento.confirmarMoneda();
        paginaBusquedaAlojamiento.confirmarCentro();
        paginaBusquedaAlojamiento.verificarBusquedaConDosFiltros();

    }
}
