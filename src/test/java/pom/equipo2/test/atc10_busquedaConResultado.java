package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFTrasladoPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class atc10_busquedaConResultado  extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladoPage paginaTraslados = null;

    @Test
    public void busquedaConResultado(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladoPage(driver);
        paginaTraslados.irTrasladoDesdeHome();
        paginaTraslados.cargarOrigen();
        paginaTraslados.cargarDestino();
        paginaTraslados.cargarFecha();
        paginaTraslados.cargarHora();
        paginaTraslados.btnPasajeros();
        paginaTraslados.cargarAdultoPasajero();
        paginaTraslados.realizarbusqueda();
        List<WebElement> listaAutos = driver.findElements(By.cssSelector("div.search-cluster.ng-scope.ng-hide"));
        int resultado= listaAutos.size();
        assertTrue(resultado>=1);




    }

}
