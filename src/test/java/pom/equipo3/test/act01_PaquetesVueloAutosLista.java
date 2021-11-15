package pom.equipo3.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.VFHomePage;
import pom.equipo3.pages.VFPaquetesPage;

public class act01_PaquetesVueloAutosLista extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFPaquetesPage paginaPaquetes = null;

    @Test
    public void paqueteTuristicoVueloauto() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
        paginaPaquetes.irVuelosAutos();
        paginaPaquetes.ingresarOrigenDestino();
        paginaPaquetes.dormir(2000);
        paginaPaquetes.ingresarFechas();
        paginaPaquetes.dormir(2000);
        paginaPaquetes.buscarPaquete();
        //validar que muestre vuelos disponibles a Miami
        String esperado = driver.findElement(By.xpath("//div[@class='itinerary-info-title']//child::span[contains(text(),'Tu viaje a Miami')]")).getText();

        Assert.assertEquals(esperado,"Tu viaje a Miami");

    }


}