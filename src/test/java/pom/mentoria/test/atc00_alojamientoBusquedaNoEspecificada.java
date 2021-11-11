package pom.mentoria.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.mentoria.base.TestBase;
import pom.mentoria.pages.VFAlojamientoPage;
import pom.mentoria.pages.VFHomePage;

import static org.junit.Assert.assertEquals;

public class atc00_alojamientoBusquedaNoEspecificada extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;

    @Test
    public void alojamientoBusquedaNoEspecificada(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.agregarHabitacionMenor();
        paginaAlojamiento.confirmarSeleccionHabitacionMenor();
        String resultado = driver.findElement(By.xpath("//p[contains(text(),'Ingresa la edad del menor')]")).getText();
        assertEquals("Ingresa la edad del menor", resultado);
    }
}
