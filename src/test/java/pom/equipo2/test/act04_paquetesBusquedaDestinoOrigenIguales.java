package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFPaquetesPages;

import static org.junit.Assert.assertEquals;

public class act04_paquetesBusquedaDestinoOrigenIguales extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPages paginaPaquetes = null;

    @Test
    public void paquetesBusquedaDestinoOrigenIguales() {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPages(driver);
        paginaPaquetes.cargarOrigen();
        paginaPaquetes.cargarDestino();
        paginaPaquetes.confirmarFechaNoDecidida();
        paginaPaquetes.confirmarMes();
        paginaPaquetes.confirmarBusqueda();
        String resultado = driver.findElement(By.xpath("//span[contains(text(),'El destino debe ser diferente del origen.')]")).getText();
        assertEquals("El destino debe ser diferente del origen.", resultado);
    }


}
