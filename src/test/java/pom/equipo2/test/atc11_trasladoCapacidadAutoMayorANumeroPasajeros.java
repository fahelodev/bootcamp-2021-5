package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFTrasladoPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class atc11_trasladoCapacidadAutoMayorANumeroPasajeros extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladoPage paginaTraslados = null;

    @Test
    public void trasladoCapacidadAutoMayorANumeroPasajeros(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslados = new VFTrasladoPage(driver);
        paginaTraslados.irTrasladoDesdeHome();
        paginaTraslados.cargarOrigen();
        paginaTraslados.cargarDestino();
        paginaTraslados.cargarFecha();
        paginaTraslados.cargarHora();
        paginaTraslados.btnPasajeros();
        paginaTraslados.cargarPasajero();
        paginaTraslados.realizarbusqueda();
        List<WebElement> listadoAutos = driver.findElements(By.cssSelector("div.search-cluster.ng-scope.ng-hide"));
        System.out.println(listadoAutos.size());
        int totalAutos = listadoAutos.size();
        int totalAutosEsperado = 2;
        assertEquals(totalAutosEsperado,totalAutos);

        //validacion de la cantidad de personas por vehiculo
        // WebElement chek = driver.findElement(By.cssSelector(".search-view-items-container > div:nth-of-type(3) span:nth-of-type(1) > span:nth-of-type(1) > span:nth-of-type(1) > span:nth-of-type(2)"));
        WebElement chek = driver.findElement(By.xpath("//div[@class='search-cluster ng-scope']/following::span[contains(text(),'14 personas ')]"));

        System.out.println(chek.getText());
        assertEquals("14 personas por vehículo", chek.getText());



    }
}

