package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFBusquedaPaquetesPages;
import pom.equipo2.pages.VFResultadoBuquedaHotelPages;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFPaquetesPages;

public class act05_paquetesBusquedaSeleccionarHabitacion extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPages paginaPaquetes = null;
    protected VFBusquedaPaquetesPages paginaBusquedaPaquetes = null;
    protected VFResultadoBuquedaHotelPages paginaBusquedaPaqueteHotel = null;

    @Test
    public void paquetesBusquedaSeleccionarHabitacion() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPages(driver);
        paginaPaquetes.cargarOrigen();
        paginaPaquetes.cargarDestino2();
        paginaPaquetes.cargarFechas();
        paginaPaquetes.confimarBusqueda();

        paginaBusquedaPaquetes = new VFBusquedaPaquetesPages(driver);
        paginaBusquedaPaquetes.seleccionarHotel();


        paginaBusquedaPaqueteHotel = new VFResultadoBuquedaHotelPages(driver);
        paginaBusquedaPaqueteHotel.cambiarFocoPagina();
        paginaBusquedaPaqueteHotel.confirmarHabitacionSuperior();
        paginaBusquedaPaqueteHotel.verificarDiferenciaPrecioHabitacion();

    }

}
