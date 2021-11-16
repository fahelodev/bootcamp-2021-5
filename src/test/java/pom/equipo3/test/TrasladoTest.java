package pom.equipo3.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.VFHomePage;
import pom.equipo3.pages.VFTrasladosPage;

import java.util.List;

public class TrasladoTest extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFTrasladosPage paginaTraslados = null;

    @Test
    public void TrasladoHotel() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladosPage(driver);
        paginaTraslados.irTrasladosDesdeHome();
        paginaTraslados.irHaciaAeropuerto();
        paginaTraslados.ingresarDesdeHacia();
        paginaTraslados.ingresarFechaPartida();
        paginaTraslados.cargarHoraDeparture();
        paginaTraslados.agregar4Pasajeros();
        paginaTraslados.dormir(2000);
        paginaTraslados.buscarPaquete();

        List<WebElement> listaP = driver.findElements(By.cssSelector("strong[class='ng-binding']"));
        int contP = listaP.size();
        System.out.println(contP);
        int contadorfinal = 0;
        while (contadorfinal < contP) {

            String text = driver.findElements(By.cssSelector("strong[class='ng-binding']")).get(contadorfinal).getText();
            contadorfinal++;

        }

        Assert.assertEquals(contP, contadorfinal);

    }
    @Test
    public void TrasladoDesdeAeropuerto() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladosPage(driver);
        paginaTraslados.irTrasladosDesdeHome();
        paginaTraslados.irAgregarRegreso();
        paginaTraslados.ingresarAeropuertoHotel();
        paginaTraslados.dormir(2000);
        paginaTraslados.ingresarFechaArribo();
        paginaTraslados.cargarHoraDeparture();
        paginaTraslados.ingresarFechaPartida();
        paginaTraslados.cargarHoraArrival();
        paginaTraslados.agregar4Pasajeros();
        paginaTraslados.dormir(2000);
        paginaTraslados.buscarPaquete();
        paginaTraslados.ingresarTipoMoneda();

        List<WebElement> listaP = driver.findElements(By.cssSelector("strong[class='ng-binding']"));
        int contP = listaP.size();
        System.out.println(contP);
        int contadorfinal = 0;
        while (contadorfinal < contP) {

            String text = driver.findElements(By.cssSelector("strong[class='ng-binding']")).get(contadorfinal).getText();
            contadorfinal++;

        }

        Assert.assertEquals(contP, contadorfinal);

    }
    @Test
    public void TrasladoNiños() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladosPage(driver);
        paginaTraslados.irTrasladosDesdeHome();
        paginaTraslados.irAgregarRegreso();
        paginaTraslados.dormir(2000);
        paginaTraslados.ingresarAeropuertoHotel();
        paginaTraslados.ingresarFechaArribo();
        paginaTraslados.cargarHoraDeparture();
        paginaTraslados.ingresarFechaPartida();
        paginaTraslados.cargarHoraArrival();
        paginaTraslados.agregarMenores();
        paginaTraslados.dormir(2000);
        paginaTraslados.buscarPaquete();
        paginaTraslados.ingresarTipoMoneda();

        List<WebElement> listaP = driver.findElements(By.cssSelector("strong[class='ng-binding']"));
        int contP = listaP.size();
        System.out.println(contP);
        int contadorfinal = 0;
        while (contadorfinal < contP) {

            String text = driver.findElements(By.cssSelector("strong[class='ng-binding']")).get(contadorfinal).getText();
            contadorfinal++;

        }

        Assert.assertEquals(contP, contadorfinal);

    }

}

