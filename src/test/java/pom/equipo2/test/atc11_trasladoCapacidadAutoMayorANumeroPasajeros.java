package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFBusquedaTrasladoPage;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFTrasladoPage;

public class atc11_trasladoCapacidadAutoMayorANumeroPasajeros extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladoPage paginaTraslados = null;
    protected VFBusquedaTrasladoPage paginaBusquedaTraslado = null;

    @Test
    public void trasladoCapacidadAutoMayorANumeroPasajeros(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladoPage(driver);
        paginaTraslados.irTrasladoDesdeHome();
        paginaBusquedaTraslado = new VFBusquedaTrasladoPage(driver);
        paginaTraslados.cargarOrigen();
        paginaTraslados.cargarDestino();
        paginaTraslados.cargarFecha();
        paginaTraslados.cargarHora();
        paginaTraslados.cargarPasajeroTest11();
        paginaTraslados.realizarbusqueda();
        paginaBusquedaTraslado.verificarTotalBusquedaTest11();
        paginaBusquedaTraslado.personasPorVehiculo();
    }
}