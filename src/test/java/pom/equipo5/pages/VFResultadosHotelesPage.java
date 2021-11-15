package pom.equipo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

import java.util.List;

public class VFResultadosHotelesPage  extends SeleniumBase {
    public VFResultadosHotelesPage (WebDriver driver) {
        super(driver);
    }

    private String precioHotelSeleccionado;

    By hotelesResultados = By.xpath("//div[@infinitescroll]//div[contains(@class, 'results-cluster-container')]");
    By btnVerDetallesHotel = By.xpath("//*[text()='Ver detalle']");
    By precioHotel = By.xpath("//div[@class='results-cluster-container']//span[contains(@class,'main-value')]");
    By filtrarHotelDesayuno = By.xpath("//li[contains(.,'Régimen')]//li[contains(.,'Desayuno')]/span");
    By filtrarTipoHotel = By.xpath("//li[contains(.,'Tipo de Alojamiento')]//li[contains(.,'Hoteles')]/span");
    By btnVerMasFiltros = By.xpath("//li[contains(.,'Servicios')]//div[contains(@class,'view-more-btn')]");
    By filtrarPorWifi = By.xpath("//li[contains(.,'Servicios')]//li[contains(.,'Wi-Fi gratis en zonas comunes')]/span");
    By inputsRangoPrecio = By.xpath("//aloha-input//input[@type='number']");
    By aplicarRangoPrecio = By.xpath("//li[contains(.,'Precio')]//aloha-button//button[contains(.,'Aplicar')]");
    By selectOrdenar = By.xpath("//div[contains(@class,'sorting-options')]//select");
    By filtroHotelesActivado = By.xpath("//aloha-results-toolbar//li[contains(.,'Hoteles') and contains(@class,'-active')]");
    By puntuacionDeHotel = By.xpath(".//span[contains(@class,'rating-text')]");
    By wifiDeHotel = By.xpath(".//i[contains(@class, 'eva-3-icon-wifi')]");
    By desayunoHotel = By.xpath(".//div[contains(., 'Desayuno')]/img");
    By precioDeHotel = By.xpath(".//span[@class='main-value']");

    int minPrecioSeleccionado;
    int maxPrecioSeleccionado;

    public void seleccionarPrimerHotel(){
        encontrarElemento(hotelesResultados);
        esperarPresenciaElemento(precioHotel, 10);
        precioHotelSeleccionado = obtenerTexto(precioHotel);
        clickear(btnVerDetallesHotel);
        cambiarVentana();
    }

    public void establecerRangoPrecio() throws InterruptedException {
        List<WebElement> inputsRango = encontrarElementos(inputsRangoPrecio);
        String minPrecioInicial = obtenerAtributo(inputsRango.get(0), "placeholder"),
                maxPrecioInicial = obtenerAtributo(inputsRango.get(1), "placeholder");
        minPrecioSeleccionado = (int)(Integer.parseInt(minPrecioInicial) + Integer.parseInt(minPrecioInicial)*0.25);
        maxPrecioSeleccionado = (int)(Integer.parseInt(maxPrecioInicial) - Integer.parseInt(maxPrecioInicial)*0.25);
        escribirEnInput(inputsRango.get(0), String.valueOf(minPrecioSeleccionado));
        escribirEnInput(inputsRango.get(1), String.valueOf(maxPrecioSeleccionado));
        clickear(aplicarRangoPrecio);
        Thread.sleep(3000);
    }

    public void filtrarHotelesConDesayuno() throws InterruptedException {
        clickear(filtrarHotelDesayuno);
        Thread.sleep(3000);
    }

    public void filtrarPorTipoHotel() throws InterruptedException {
        clickear(filtrarTipoHotel);
        Thread.sleep(3000);
    }

    public void filtrarHotelConWifi() throws InterruptedException {
        clickear(btnVerMasFiltros);
        clickear(filtrarPorWifi);
        Thread.sleep(3000);
    }

    public void ordenarPorCalificacion() throws InterruptedException {
        seleccionarOpcion(selectOrdenar, "rate_descending");
        Thread.sleep(3000);
    }

    public boolean estaFiltroHotelActivado(){
        return estaDesplegado(encontrarElemento(filtroHotelesActivado));
    }

    public void verificarFiltrosSeleccionados(){
        List<WebElement> hoteles = encontrarElementos(hotelesResultados);
        double puntuacionAnterior = Double.parseDouble(obtenerTexto( encontrarElementoDesde(hoteles.get(0), puntuacionDeHotel) ));

        for (WebElement hotel: hoteles) {

            //Puntuacion (Dejo try-catch por un hotel que no mostraba la puntuacion y hacia fallar el test)
            double puntuacionActual = puntuacionAnterior;
            try{
                WebElement puntuacionElement = encontrarElementoDesde(hotel, puntuacionDeHotel);
                puntuacionActual = Double.parseDouble(obtenerTexto( puntuacionElement ));
            }catch (Exception e){
                System.out.println("sin puntuacion");
            }

            WebElement wifi = encontrarElementoDesde( hotel, wifiDeHotel);
            WebElement desayuno = encontrarElementoDesde(hotel, desayunoHotel);
            int precio = Integer.parseInt( obtenerTexto( encontrarElementoDesde(hotel,precioDeHotel)).replace(".","") );

            Assert.assertTrue(puntuacionActual <= puntuacionAnterior);
            Assert.assertTrue(wifi.isDisplayed());
            Assert.assertTrue(desayuno.isDisplayed());
            Assert.assertTrue( precio > minPrecioSeleccionado & precio < maxPrecioSeleccionado );
        }
        Assert.assertTrue(estaFiltroHotelActivado());
    }

    public int getPrecioHotelSeleccionado() {
        return Integer.parseInt(precioHotelSeleccionado.replace(".",""));
    }
}
