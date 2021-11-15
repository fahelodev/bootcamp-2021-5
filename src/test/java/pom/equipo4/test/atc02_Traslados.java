package pom.equipo4.test;

import org.junit.Test;
import pom.equipo4.base.TestBase;
import pom.equipo4.pages.VFHomePage;
import pom.equipo4.pages.VFPaquetesPage;
import pom.equipo4.pages.VFTrasladosPage;
import sun.security.krb5.internal.PAData;

public class atc02_Traslados extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladosPage paginaTraslados = null;

    @Test
    public void trasladosBusquedaYMostrarMapa() {
        cargarHome();
        paginaTraslados.clickearTrasladoCard();
        paginaTraslados.abrirMapaYCerrarlo();
    }

    @Test
    public void trasladosBusquedaCambioHoraYMoneda()
    {
        cargarHome();
        paginaTraslados.ingresarOrigenDestinoVuelo("origin","ezeiza");
        paginaTraslados.ingresarOrigenDestinoVuelo("destination","hilton");
        paginaTraslados.selectArriboOPartida('a',"1");
        paginaTraslados.aplicarBusqueda(false);
        paginaTraslados.modificarDatosViaje();
        paginaTraslados.cambiarMoneda();
        paginaTraslados.comprarTraslado();
        paginaTraslados.checkearCanjePuntosYPromocionesConFormasPago();
    }

    @Test
    public void trasladosBusquedaValidarCanjePuntosYFormasPago()
    {
        cargarHome();
        paginaTraslados.ingresarOrigenDestinoVuelo("origin","ezeiza");
        paginaTraslados.ingresarOrigenDestinoVuelo("destination","hilton");
        paginaTraslados.cambiarDesdeAeropuertoHasta();
        paginaTraslados.selectArriboOPartida('p',"1");
        paginaTraslados.agregarHoraViaje();
        paginaTraslados.agregarPasajeros();
        paginaTraslados.aplicarBusqueda(false);
        paginaTraslados.cambiarMoneda();
        paginaTraslados.comprarTraslado();
        paginaTraslados.checkearCanjePuntosYPromocionesConFormasPago();
    }


    public void cargarHome()
    {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaHome.irSeccionDesdeHome("traslados");
        paginaTraslados = new VFTrasladosPage(driver);
    }
}
