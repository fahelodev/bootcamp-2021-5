package pom.equipo3.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.VFHomePage;
import pom.equipo3.pages.VFPaquetesPage;

public class PaquetesTest extends TestBase {
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
    @Test
    public void paquetesMasDe8Personas() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
        paginaPaquetes.irVuelosAutos();
        paginaPaquetes.ingresarOrigenDestino();
        paginaPaquetes.dormir(2000);
        paginaPaquetes.ingresarFechas();
        paginaPaquetes.dormir(2000);
        paginaPaquetes.agregar8Pasajeros();


        String alerta = driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock__itemRows _pnlpk-dynamicContent']//div//div[1]//div[2]//div//div//div//span[contains(text(),'Solo puedes hacer búsquedas de hasta 8 personas')]")).getText();
        //validar mensaje de alerja al ingresar mas de 8 personas
        String esperado = "Solo puedes hacer búsquedas de hasta 8 personas";
        Assert.assertEquals(esperado,alerta);

    }
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