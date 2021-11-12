package pom.equipo4.test;

import org.junit.Test;
import pom.equipo4.base.TestBase;
import pom.equipo4.pages.VFHomePage;
import pom.equipo4.pages.VFPaquetesPage;

public class atc01_Paquetes extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPage paginaPaquetes = null;

    @Test
    public void paquetesBusquedaCompleta() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome(); //TODO HACER QUE ESTA LINEA SE USE UNA SOLA VEZ YA QUE SE TIENE QUE ESTAR USANDO EN TODOS LOS TESTS
        paginaPaquetes.ingresarOrigenDestinoVuelo("origin","santiago"); //TODO LO MISMO
        paginaPaquetes.ingresarOrigenDestinoVuelo("destination","new york");
        paginaPaquetes.aplicarBusqueda(true);
        paginaPaquetes.seleccionarPrimerHotelResultadosBusqueda(false);
        //TODO se puede copiar todo esto para ponerlo en una sola linea en cada test? (se usan todas las lineas, solo cambia el false de la ultima que va con true, y los destinos)
    }

    @Test
    public void paquetesBusquedaServiciosYComentarios() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.ingresarOrigenDestinoVuelo("origin","santiago");
        paginaPaquetes.ingresarOrigenDestinoVuelo("destination","ciudad de méxico");
        paginaPaquetes.aplicarBusqueda(true);
        paginaPaquetes.seleccionarPrimerHotelResultadosBusqueda(true);
        paginaPaquetes.verServiciosYComentarios();
    }

    @Test
    public void paquetesBusquedaMostrar5EstrellasAgregarAct() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.ingresarOrigenDestinoVuelo("origin","santiago");
        paginaPaquetes.ingresarOrigenDestinoVuelo("destination","rio de janeiro");
        paginaPaquetes.aplicarBusqueda(true);
        paginaPaquetes.seleccionarFiltro5Estrellas();
        paginaPaquetes.seleccionarPrimerHotelResultadosBusqueda(true);
        paginaPaquetes.procederCompra();
        paginaPaquetes.agregarActividadYEntrarCompraViaje();
    }
}
