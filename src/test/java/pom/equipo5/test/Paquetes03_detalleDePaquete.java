package pom.equipo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.*;

public class Paquetes03_detalleDePaquete extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFPaquetePage paginaPaquete = null;
    protected VFPaqueteAlojamientosPage paginaPaqueteAlojamiento = null;
    protected VFPaqueteHabitacionesPage paginaPaqueteHabitacion = null;
    protected VFPaqueteVuelosPage paginaPaqueteVuelos = null;
    protected  VFPaqueteAdicionalesPage paginaPaqueteAdicionales = null;
    protected VFCheckoutPage paginaCheckout = null;


    @Test
    public void detalleDePaquete() {
        paginaHome = new VFHomePage(driver);
        paginaPaquete = new VFPaquetePage(driver);
        paginaCheckout = new VFCheckoutPage(driver);
        paginaPaqueteVuelos = new VFPaqueteVuelosPage(driver);
        paginaPaqueteAlojamiento = new VFPaqueteAlojamientosPage(driver);
        paginaPaqueteHabitacion = new VFPaqueteHabitacionesPage(driver);
        paginaPaqueteAdicionales = new VFPaqueteAdicionalesPage(driver);

        paginaHome.irHomePage();
        paginaHome.irPaquete();
        paginaPaquete.rellenarFormularioUnAlojamiento();
        paginaPaquete.realizarLaBusqueda();
        paginaPaqueteAlojamiento.seleccionarPrimerAlojamiento();
        paginaPaqueteHabitacion.seleccionarHabitacionRecomendada();
        paginaPaqueteVuelos.seleccionarPrimerVuelo();
        paginaPaqueteAdicionales.seleccionarTraslado();
        paginaPaqueteAdicionales.seleccionarAuto();
        paginaPaqueteAdicionales.seleccionarActividad();
        paginaPaqueteAdicionales.obtenerVuelos();
        paginaPaqueteAdicionales.confirmarPaquete();
        paginaCheckout.obtenerDetallesDePaquete();
        Assert.assertTrue(paginaCheckout.getVuelo().contains(paginaPaqueteAdicionales.getVueloDestino()));
        Assert.assertTrue(paginaCheckout.getVuelo().contains(paginaPaqueteAdicionales.getVueloSalida()));
        Assert.assertEquals(paginaCheckout.getAlojamiento(), paginaPaqueteAlojamiento.getAlojamiento());
        Assert.assertEquals(paginaCheckout.getAuto(), paginaPaqueteAdicionales.getAuto());
        Assert.assertEquals(paginaCheckout.getActividad(), paginaPaqueteAdicionales.getActividad());
        Assert.assertTrue(!paginaCheckout.getTraslado().isEmpty());
    }
}