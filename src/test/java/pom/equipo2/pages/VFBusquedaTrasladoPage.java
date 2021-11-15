package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VFBusquedaTrasladoPage extends SeleniumBase {

    public VFBusquedaTrasladoPage(WebDriver driver) {
        super(driver);
    }

    By listadoAutos = By.cssSelector("div.search-cluster.ng-scope.ng-hide");
    By chekPersonas = By.xpath("//div[@class='search-cluster ng-scope']/following::span[contains(text(),'14 personas ')]");
    int totalAutosEsperado = 2;
    String descripcionVehiculo = "14 personas por vehículo";
    By mensaje01Test09 = By.cssSelector("h5.eva-3-h5");
    By mensaje02Test09 = By.cssSelector("a.ng-binding");
    String resultadoEsperado1Test09 = "¡Ups! No hay traslados disponibles para esta fecha.";
    String resultadoEsperado2Test09 = "Sentimos no poder ayudarte. Esperamos que encuentres lo que estás buscando.";

    public void verificarTotalBusquedaTest11(){
        assertEquals(totalAutosEsperado,tamanoLista(listadoAutos));
    }

    public void personasPorVehiculo(){
        assertEquals(descripcionVehiculo,obtenerTexto(chekPersonas));
    }

    public void verificarTotalBusquedaTest10(){
        assertTrue(tamanoLista(listadoAutos)>=1);
    }

    public void comprobarMensaje(){
        assertEquals(resultadoEsperado1Test09,obtenerTexto(mensaje01Test09));
        assertEquals(resultadoEsperado2Test09,obtenerTexto(mensaje02Test09));
    }
}