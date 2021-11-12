package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFAlojamientoPage;
import pom.equipo2.pages.VFHomePage;


import static org.junit.Assert.assertEquals;

public class act00_alojamientoBusquedaEdadNoEspecificada extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;

    @Test
    public void alojamientoBusquedaEdadNoEspecificada(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.agregarMenorHabitacion();
        paginaAlojamiento.confirmarSeleccionHabitacionMenor();
        String resultado = driver.findElement(By.xpath("//p[contains(text(),'Ingresa la edad del menor')]")).getText();
        assertEquals("Ingresa la edad del menor", resultado);
    }
}
