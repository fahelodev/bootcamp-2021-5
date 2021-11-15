package pom.equipo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.*;

public class Paquetes02_precioFinalCoincide extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFPaquetePage paginaPaquete = null;
    protected VFPaqueteVuelosPage paginaPaqueteVuelos = null;
    protected VFPaqueteAlojamientosPage paginaPaquetePrimerAlojamiento = null;
    protected VFPaqueteHabitacionesPage paginaPaquetePrimeraHabitacion = null;
    protected VFPaqueteAlojamientosPage paginaPaqueteSegundoAlojamiento = null;
    protected VFPaqueteHabitacionesPage paginaPaqueteSegundaHabitacion = null;
    protected VFCheckoutPage paginaCheckout = null;

    @Test
    public void precioFinalCoincide() {
        paginaHome = new VFHomePage(driver);
        paginaPaquete = new VFPaquetePage(driver);
        paginaPaqueteVuelos = new VFPaqueteVuelosPage(driver);
        paginaPaquetePrimerAlojamiento = new VFPaqueteAlojamientosPage(driver);
        paginaPaquetePrimeraHabitacion = new VFPaqueteHabitacionesPage(driver);
        paginaPaqueteSegundoAlojamiento = new VFPaqueteAlojamientosPage(driver);
        paginaPaqueteSegundaHabitacion = new VFPaqueteHabitacionesPage(driver);
        paginaCheckout = new VFCheckoutPage(driver);

        paginaHome.irHomePage();
        paginaHome.irPaquete();
        paginaPaquete.rellenarFormularioDosAlojamientos();
        paginaPaquete.realizarLaBusqueda();
        paginaPaqueteVuelos.seleccionarPrimerVuelo();
        paginaPaquetePrimerAlojamiento.seleccionarAlojamientoRecomendado();
        paginaPaquetePrimeraHabitacion.seleccionarHabitacionRecomendada();
        paginaPaqueteSegundoAlojamiento.seleccionarAlojamientoRecomendado();
        paginaPaqueteSegundaHabitacion.seleccionarHabitacionRecomendada();
        paginaCheckout.obtenerPrecio();

        Assert.assertEquals(paginaCheckout.getPrecioFinal(), paginaPaqueteSegundaHabitacion.obtenerPrecioDePaquete(), 1000);
    }
}