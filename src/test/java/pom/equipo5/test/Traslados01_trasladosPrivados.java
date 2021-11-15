package pom.equipo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.VFHomePage;
import pom.equipo5.pages.VFResultadosTrasladosPage;
import pom.equipo5.pages.VFTrasladoPage;

public class Traslados01_trasladosPrivados extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFTrasladoPage paginaTraslado = null;
    protected VFResultadosTrasladosPage paginaResultadoTraslados = null;

    @Test
    public void trasladosPrivados() {
        paginaHome = new VFHomePage(driver);
        paginaTraslado = new VFTrasladoPage(driver);
        paginaResultadoTraslados = new VFResultadosTrasladosPage(driver);

        paginaHome.irHomePage();
        paginaHome.irTraslado();
        paginaTraslado.rellenarFormulario();
        paginaTraslado.realizarLaBusqueda();
        paginaResultadoTraslados.filtrarPorPrivados();

        Assert.assertTrue(paginaResultadoTraslados.confirmarTipoDeResultados("Privado"));
    }
}