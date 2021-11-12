package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

import java.util.List;

public class VFCheckoutPage extends SeleniumBase {
    public VFCheckoutPage (WebDriver driver) {
        super(driver);
    }

    private String precioFinal;
    private String fechaEntrada;
    private String fechaSalida;

    By checkoutDetalles = By.className("checkout-details");
    By fechasCheckout = By.xpath("//div[contains(@class,'dm-date')]");
    By precioFinalCheckout = By.xpath("//span[contains(@upaconceptname,'totalPrice')]");
    By trasladoRecogida = By.cssSelector("#transfer-pickup-T0 p");
    By trasladoBajada = By.cssSelector("#transfer-dropoff-T0 p");
    By trasladoNumeroDePasajeros = By.cssSelector("span.chk-pricebox-item-description");


    public void obtenerDetallesCheckout(){
        WebElement detallesPago = encontrarElemento(checkoutDetalles);
        List<WebElement> fechas = encontrarElementosDesde(detallesPago, fechasCheckout);
        fechaEntrada = obtenerTexto(fechas.get(0));
        fechaSalida = obtenerTexto(fechas.get(1));
        precioFinal = obtenerTexto(encontrarElementoDesde(detallesPago,precioFinalCheckout));
    }

    public String getTrasladoRecogida(){
        esperarPresenciaElemento(trasladoRecogida, 15);
        return obtenerTexto(trasladoRecogida);
    }

    public String getTrasladoBajada(){
        esperarPresenciaElemento(trasladoBajada, 15);
        return obtenerTexto(trasladoBajada);
    }

    public String getTrasladoNumeroDePasajeros(){
        esperarPresenciaElemento(trasladoNumeroDePasajeros, 15);
        return obtenerTexto(trasladoNumeroDePasajeros);
    }

    public int getPrecioFinal() {
        return Integer.parseInt(precioFinal.replace(".",""));
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }
}
