package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.VFAlojamientoPage;
import pom.equipo5.pages.VFHomePage;
import pom.equipo5.pages.VFResultadosHotelesPage;

public class Alojamiento03_BusquedaYFiltros extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;
    protected VFResultadosHotelesPage paginaResultadoHoteles = null;

    @Test
    public void busquedaYFiltros() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaResultadoHoteles = new VFResultadosHotelesPage(driver);

        paginaHome.irHomePage();
        paginaHome.irAlojamiento();
        paginaAlojamiento.rellenarFormulario();
        paginaAlojamiento.realizarLaBusqueda();
        paginaResultadoHoteles.establecerRangoPrecio();
        paginaResultadoHoteles.filtrarHotelesConDesayuno();
        paginaResultadoHoteles.filtrarPorTipoHotel();
        paginaResultadoHoteles.filtrarHotelConWifi();
        paginaResultadoHoteles.ordenarPorCalificacion();
        paginaResultadoHoteles.verificarFiltrosSeleccionados();
    }
}
