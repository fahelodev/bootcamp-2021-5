package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;
import static org.junit.Assert.assertTrue;

public class VFBusquedaAlojamientoPage extends SeleniumBase {

    public VFBusquedaAlojamientoPage(WebDriver driver) {
        super(driver);
    }

    By etiquetaCantidadAlojamiento = By.xpath("//span[contains(text(),'alojamientos')]/ancestor::span[3]/child::span[2]");
    By etiquetaCantidadCentro = By.xpath("//span[contains(text(),'Centro') and not(contains(text(),'de'))]/ancestor::span[3]/child::span[2]");
    By etiquetaCentro = By.xpath("//span[contains(text(),'Centro') and not(contains(text(),'de'))]/ancestor::em");
    By listaMoneda = By.cssSelector("Select.select-tag");
    By campoMinimo = By.xpath("//input[@class='input-tag' and @placeholder=@min]");
    By campoMaximo = By.xpath("//input[@class='input-tag' and @placeholder=@max]");
    By btnAplicarMoneda = By.xpath("//em[contains(text(),'Aplicar')]");
    Integer totalAlojamiento;
    Integer totalCentro;


    public void confirmarCentro(){
        clickear(etiquetaCentro);
    }


    public void confirmarMoneda (){
        seleccionarElementoPorValor(listaMoneda,"USD");
        esperaExplicitaPrecenciaElementos(campoMinimo,7);
        ingresarTexto(campoMinimo,"110");
        ingresarTextoBorrandoElPorDefecto(campoMaximo,"400");
        clickear(btnAplicarMoneda);

    }

    public void verificarAlMenosUnResultado(){
        totalAlojamiento= Integer.parseInt(obtenerTexto(etiquetaCantidadAlojamiento));
        assertTrue(totalAlojamiento >= 1);
    }

    public void verificarBusquedaConDosFiltros(){
        totalCentro= Integer.valueOf(obtenerTexto(etiquetaCantidadCentro));
        assertTrue(totalCentro > 1);
    }
}