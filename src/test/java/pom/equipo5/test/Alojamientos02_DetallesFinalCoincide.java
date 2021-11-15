package pom.equipo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.*;

public class Alojamientos02_DetallesFinalCoincide extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;
    protected VFResultadosHotelesPage paginaResultadoHoteles = null;
    protected VFDetallesHotelPage paginaDetallesHotel = null;
    protected VFTripsPage paginaTrips = null;
    protected VFCheckoutPage paginaCheckout = null;

    @Test
    public void detallesFinalCoincide() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaResultadoHoteles = new VFResultadosHotelesPage(driver);
        paginaDetallesHotel = new VFDetallesHotelPage(driver);
        paginaTrips = new VFTripsPage(driver);
        paginaCheckout = new VFCheckoutPage(driver);

        paginaHome.irHomePage();
        paginaHome.irAlojamiento();
        paginaAlojamiento.rellenarFormulario();
        paginaAlojamiento.realizarLaBusqueda();
        paginaResultadoHoteles.seleccionarPrimerHotel();
        paginaDetallesHotel.reservarHabitacion();
        paginaTrips.irCheckout();
        paginaCheckout.obtenerDetallesCheckout();

        Assert.assertEquals(paginaCheckout.getPrecioFinal(), paginaResultadoHoteles.getPrecioHotelSeleccionado(), 100);
        Assert.assertTrue(paginaCheckout.getFechaEntrada().contains( paginaAlojamiento.getFechaEntradaIngresada() ));
        Assert.assertTrue(paginaCheckout.getFechaSalida().contains( paginaAlojamiento.getFechaSalidaIngresada() ));

    }
}
