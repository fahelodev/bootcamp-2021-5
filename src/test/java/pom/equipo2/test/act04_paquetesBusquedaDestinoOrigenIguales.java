package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFPaquetesPages;

public class act04_paquetesBusquedaDestinoOrigenIguales extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPages paginaPaquetes = null;

    @Test
    public void paquetesBusquedaDestinoOrigenIguales() {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPages(driver);
        paginaPaquetes.cargarOrigen();
        paginaPaquetes.cargarDestino();
        paginaPaquetes.confirmarFechaNoDecidida();
        paginaPaquetes.confirmarMes();
        paginaPaquetes.confirmarBusqueda();
        paginaPaquetes.verificarDestinoOrigenDistinto();
    }


}
