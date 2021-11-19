package pom.equipo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.*;

public class Paquetes01_paqueteRecomendado extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFPaquetePage paginaPaquete = null;
    protected VFPaqueteVuelosPage paginaPaquteVuelos = null;
    protected VFPaqueteAlojamientosPage paginaPaquetePrimerAlojamiento = null;
    protected VFPaqueteRecomendadoDetalle paginaPaqueteRecomendadoDetalle = null;

    @Test
    public void paqueteRecomendado() {
        paginaHome = new VFHomePage(driver);
        paginaPaquete = new VFPaquetePage(driver);
        paginaPaquteVuelos = new VFPaqueteVuelosPage(driver);
        paginaPaquetePrimerAlojamiento = new VFPaqueteAlojamientosPage(driver);
        paginaPaqueteRecomendadoDetalle = new VFPaqueteRecomendadoDetalle(driver);

        paginaHome.irHomePage();
        paginaHome.irPaquete();
        paginaPaquete.selecionarPrimerPaqueteRecomendado();
        paginaPaquetePrimerAlojamiento.seleccionarPaqueteSugerido();
        paginaPaqueteRecomendadoDetalle.esperarDetallesPaquete();

        Assert.assertEquals("VUELO", paginaPaqueteRecomendadoDetalle.getVuelo());
        Assert.assertEquals("ALOJAMIENTO", paginaPaqueteRecomendadoDetalle.getAlojamiento());
    }
}