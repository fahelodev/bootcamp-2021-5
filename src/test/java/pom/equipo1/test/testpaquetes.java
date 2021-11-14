package pom.equipo1.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFpaquetesPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testpaquetes extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFpaquetesPage paginaPaquetes = null;

    @Test
    public void CdP03_busquedaPaquetes(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFpaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
        paginaPaquetes.seleccionarVuelo1Alojamiento();
        paginaPaquetes.llenarCasillaOrigen("santiago","Santiago de Chile");
        paginaPaquetes.llenarCasillaDestino("san pedro","San Pedro de Atacama");
        paginaPaquetes.llenarCampoFecha(1,2);
        paginaPaquetes.seleccionarCantidadPasajeros(2);
        paginaPaquetes.darClickBuscar();
        paginaPaquetes.resultadosBusqueda();
        int lista = driver.findElements(By.cssSelector("div.results-cluster-container")).size();
        assertTrue(lista>1);
        //paginaPaquetes.confirmarSeleccionHabitacionMenor();
        //String resultado = driver.findElement(By.xpath("//p[contains(text(),'Ingresa la edad del menor')]")).getText();
        //assertEquals("Ingresa la edad del menor", resultado);
    }
}
