package pom.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo3.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosPage extends SeleniumBase {
    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamiento')]");
    By divDatosViaje = By.xpath("//div[@class='sbox-show-hide-container -sbox-3-shadow-static']");
    By btnSerchBox = By.xpath("//input[@placeholder='Ingresa una ciudad, alojamiento o atracción']");
    By btnOrigen = By.xpath("//input[@placeholder='Entrada']");
    By btnDestino = By.xpath("//input[@placeholder='Salida']");
    By btnPasajerosEdad = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select/option[9]");
    By btnPasajerosEdad1 = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div/div/select/option[14]");

    By btnPasajeros = By.xpath("//label[contains(text(),'Habitaciones')]");
    By btnAgregarPasajero = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By listaViajes = By.xpath("//div[@class='ac-group-container']//child::ul/li[1]");
    By listaFechas = By.xpath("//span[@class='_dpmg2--date-number']");
    By btnfechaEntrada = By.xpath("//input[@placeholder='Entrada']");
    By btn4estrellas = By.xpath("//li[contains(.,'Estrellas')]//li[@class='dropdown-subitem'][3]");
    By btn5estrellas = By.xpath("//li[contains(.,'Estrellas')]//li[@class='dropdown-subitem'][2]");
    By btnOfertas = By.xpath("//em/span[contains(text(),' Todas las ofertas ')]");
    By btnHotel = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button");
    By campoDestino = By.xpath("//input[contains(@class,'sbox-main')]");
    By listaElementos = By.cssSelector("div.ac-container ul>li");
    By errorFound = By.cssSelector(".ac-group-hint-error");
    By Ordenar = By.xpath ("//aloha-select[@class='sorting-select']//select[@class='select-tag']/option");
    By Shotel = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button");
    By Hotel = By.xpath("//span[contains(text(),'Libertador Hotel')]");
    By Oferta = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(5) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(1) > span > span.filters-checkbox > aloha-checkbox > span > label > em > span");




    //Funciones que se usan en todos los tests de paquetes

    public void irAlojamiento() {
        clickear(btnAlojamiento);
        esperaExplicitaElementoClickeable(divDatosViaje, 5);
    }

    public void cargarDestinoBSAS(){
        ingresarTexto(campoDestino,"buenos");
        seleccionarTextoLista(listaElementos,"Buenos Aires, Ciudad de Buenos Aires, Argentina");
    }


    public void cargarDestinoMiami(){
        ingresarTexto(campoDestino,"miami");
        seleccionarTextoLista(listaElementos,"Miami Beach, Florida, Estados Unidos");
    }
    public void cargarDestinoPinchas(){
        ingresarTexto(campoDestino,"Pinchas");
    }
    public void ValidacionExistencia(){
        String b= "No se encontraron resultados que coincidan con";
        String selected = obtenerTexto(errorFound);
        Assert.assertEquals("No se encontraron resultados que coincidan con" + "pinchas",b+selected);
    }




    public void cargarFechas()
    {
        clickear(btnOrigen);
        asignarFechaDisponible(10);
        clickear(btnDestino);
        clickear(btnDestino);
        asignarFechaDisponible(12);
    }


    public void botonBuscar()
    {
        clickear(btnBuscar);

    }

    public void filtro4estrellas()
    {
        clickear(btn4estrellas);
    }
    public void filtro5estrellas()
    {
        clickear(btn5estrellas);
    }

    public void filtroOfertas()
    {

        clickear(btnOfertas);
    }
    public void AgregarPasajero()
    {
        clickear(btnPasajeros);
        clickear(btnAgregarPasajero);
        clickear(btnAgregarPasajero);
        clickear(btnPasajerosEdad);
        clickear(btnPasajerosEdad1);
    }

    public void filtroOrdenar()
    {
        esperaExplicitaElementoClickeable(Ordenar,5);
        List<WebElement> eligeOrdenar = encontrarElementos(Ordenar);

        //espera.until(ExpectedConditions.elementToBeClickable(Ordenar);
        for (WebElement l : eligeOrdenar) {
            if (l.getText().contains("Precio: menor a mayor")) {
                l.click();
                break;
            }

        }
    }

    public void ValidacionHotel(){
        clickear(Shotel);

        String selected = obtenerTexto(Hotel);
        Assert.assertEquals("Libertador Hotel",selected);
    }

    public void ValidacioOferta(){

        String selected = obtenerTexto(Oferta);
        Assert.assertEquals("Todas las ofertas",selected);
    }

    public void Hotel()
    {
        esperaExplicitaElementoClickeable(btnHotel,5);
        clickear(btnHotel);
    }

}