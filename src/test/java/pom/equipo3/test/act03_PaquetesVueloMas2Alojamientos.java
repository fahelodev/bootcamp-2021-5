package pom.equipo3.test;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.VFHomePage;
import pom.equipo3.pages.VFPaquetesPage;

public class act03_PaquetesVueloMas2Alojamientos extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFPaquetesPage paginaPaquetes = null;

    @Test
    public void paqueteTuristicoVueloMas2Alojamientos() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
        paginaPaquetes.irVuelosMas2Alojamientos();
        paginaPaquetes.ingresarOrigenDestinoVuelosAlojamientos();
        paginaPaquetes.ingresarfechaAlojamiento();
        paginaPaquetes.ingresarDestinoAlojamiento();
        paginaPaquetes.buscarVueloMasAlojamientos();
        //obtener mensaje de vuelos
        String vuelosEsperados = driver.findElement(By.xpath("//span[contains(text(), 'Este es el vuelo más conveniente ')]")).getText();
        String esperado= "Este es el vuelo más conveniente";
        Assert.assertEquals(esperado,vuelosEsperados);

    }


}
