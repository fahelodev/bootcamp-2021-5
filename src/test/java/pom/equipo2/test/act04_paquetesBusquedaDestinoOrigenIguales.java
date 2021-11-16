package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFServicioPaquetesPages;

public class act04_paquetesBusquedaDestinoOrigenIguales extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFServicioPaquetesPages paginaPaquetes = null;

    @Test
    public void paquetesBusquedaDestinoOrigenIguales() {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFServicioPaquetesPages(driver);
        paginaPaquetes.cargarOrigen();
        paginaPaquetes.cargarDestino();
        paginaPaquetes.confirmarFechaNoDecidida();
        paginaPaquetes.confirmarMes();
        paginaPaquetes.confirmarBusqueda();
        paginaPaquetes.verificarDestinoOrigenDistinto();
    }


}
