package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFAlojamientoPage;
import pom.equipo2.pages.VFHomePage;

import static org.junit.Assert.assertTrue;

public class act02_alojamientoBusquedaDosFiltros extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;

    @Test
    public void act02_alojamientoBusquedaDosFiltros(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.cargarDestino();
        paginaAlojamiento.cargarFechas();
        paginaAlojamiento.confirmarBusqueda();
        paginaAlojamiento.confirmarMoneda();
        paginaAlojamiento.confirmarCentro();

        String resultadoFinal= driver.findElement(By.xpath("//span[contains(text(),'Centro') and not(contains(text(),'de'))]/ancestor::span[3]/child::span[2]")).getText();
        System.out.println(resultadoFinal);
        Integer res = Integer.valueOf(resultadoFinal);
        assertTrue("El numero total de alojaminetos es" + res, res > 1);
    }
}
