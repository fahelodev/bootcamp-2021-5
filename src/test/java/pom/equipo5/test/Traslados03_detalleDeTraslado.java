package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.VFCheckoutPage;
import pom.equipo5.pages.VFHomePage;
import pom.equipo5.pages.VFResultadosTrasladosPage;
import pom.equipo5.pages.VFTrasladoPage;
import org.junit.Assert;

public class Traslados03_detalleDeTraslado extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFTrasladoPage paginaTraslado = null;
    protected VFResultadosTrasladosPage paginaResultadoTraslados = null;
    protected VFCheckoutPage paginaCheckout = null;

    @Test
    public void detalleDeTraslado() {
        paginaHome = new VFHomePage(driver);
        paginaTraslado = new VFTrasladoPage(driver);
        paginaResultadoTraslados = new VFResultadosTrasladosPage(driver);
        paginaCheckout = new VFCheckoutPage(driver);

        paginaHome.irHomePage();
        paginaHome.irTraslado();
        paginaTraslado.rellenarFormularioHaciaAeropuerto();
        paginaTraslado.realizarLaBusqueda();
        paginaResultadoTraslados.seleccionarPrimerTraslado();

        Assert.assertTrue(paginaTraslado.getAlojamiento().contains(paginaCheckout.getTrasladoRecogida()));
        Assert.assertTrue(paginaTraslado.getAeropuerto().contains(paginaCheckout.getTrasladoBajada()));
        Assert.assertEquals("Traslado para 4 personas", paginaCheckout.getTrasladoNumeroDePasajeros());
    }
}