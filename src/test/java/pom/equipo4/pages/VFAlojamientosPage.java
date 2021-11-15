package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pom.equipo4.base.SeleniumBase;

public class VFAlojamientosPage extends SeleniumBase {
    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    By listaNombresHotelesPrimero = By.xpath("//li[@class='item -active']");
    By btnBusquedaViaje = By.xpath("//div[@class='sbox-button-container']");
    By switchSinFechaViaje = By.xpath("//label[@class='checkbox-label']");
    By filtroMejorPuntuacion = By.id("sorting");
    By dropDownTipoMoneda = By.xpath("//select[@id='currency']");


    //Funciones usadas en el primer Test

    public void ingresarDestinoAlojamiento(String ciudad) {
        By inputOrigenYDestino = By.cssSelector("div.input-container .sbox-destination");
        ingresarTexto(inputOrigenYDestino, ciudad);
        esperaExplicitaPrescenciaElemento(listaNombresHotelesPrimero, 10);
        clickear(listaNombresHotelesPrimero);
        Assert.assertEquals(obtenerTexto(listaNombresHotelesPrimero), obtenerTexto(inputOrigenYDestino));
    }

    public void aplicarBusqueda(Boolean sinFechaViaje) {
        if (sinFechaViaje) {
            clickear(switchSinFechaViaje);
        }
        clickear(btnBusquedaViaje);
    }

    public void filtrarMejorPuntuacion() {
        selectDropDown(filtroMejorPuntuacion, "Mejor puntuación");
    }

    public void cambiarMoneda() {
        esperaExplicitaElementoClickeable(dropDownTipoMoneda, 10);
        selectDropDown(dropDownTipoMoneda, "Dólar");
    }

    public void selectDropDown(By path, String text) {
        Select s = new Select(encontrarElemento(path));
        s.selectByVisibleText(text);
        Assert.assertNotNull(s.getFirstSelectedOption());
    }

    public void busquedaAlojamiento(String alojamiento) throws InterruptedException {
        esperaExplicitaPrescenciaElemento(By.xpath("//label[starts-with(@class,'checkbox-label')]"), 10);
        Thread.sleep(1500);
        encontrarElemento(By.xpath("//a[contains(text(),'" + alojamiento + "')]")).click();
        Thread.sleep(1500);
        selectPestana(1);
    }

    public void mostrarFAQ() {
        //Obtenemos una lista de cada FAQ y las desplegamos una por una
        int count = encontrarElementos(By.cssSelector(".-detail-section-padding .dropdown-item")).size();
        for (int i = 0; i < count; i++) {
            encontrarElementos(By.cssSelector(".-detail-section-padding .dropdown-item")).get(i).click();
            //Capturamos el titulo del alojamiento seleccionado
            String TituloHotel = obtenerTexto(By.xpath("//span[@class='accommodation-name eva-3-h2']"));
            String checkTituloHotel = "The Chelsea Harbour Hotel";

            Assert.assertEquals(checkTituloHotel, TituloHotel);
        }


    }
}
