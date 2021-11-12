package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFAlojamientoPage;
import pom.equipo2.pages.VFHomePage;

import static org.junit.Assert.assertTrue;


public class act01_alojamientoBusquedaConResultado extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;

    @Test
    public void alojamientoBusquedaConResultado(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.cargarDestino();
        paginaAlojamiento.cargarFechas();
        paginaAlojamiento.confirmarBusqueda();
        Integer result = Integer.parseInt(driver.findElement(By.xpath("//span[contains(text(),'alojamientos')]/ancestor::span[3]/child::span[2]")).getText());
        //Se valida que existe al menos un alojamiento
        assertTrue(result >= 1);
    }

}
