package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFBusquedaTrasladoPage;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFTrasladoPage;

public class atc09_busquedaSinResultado extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladoPage paginaTraslados = null;
    protected VFBusquedaTrasladoPage paginaBusquedaTraslado = null;

    @Test
    public void busquedaSinResultado(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladoPage(driver);
        paginaTraslados.irTrasladoDesdeHome();
        paginaBusquedaTraslado = new VFBusquedaTrasladoPage(driver);
        paginaTraslados.seleccionarHaciaAeropuerto();
        paginaTraslados.cargarDestinoTest09();
        paginaTraslados.cargarOrigenTest09();
        paginaTraslados.cargarFechaTest09();
        paginaTraslados.cargarHoraTest09();
        paginaTraslados.realizarbusqueda();
        paginaBusquedaTraslado.comprobarMensaje();
    }
}