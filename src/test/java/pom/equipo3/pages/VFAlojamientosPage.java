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


    By btnPasajeros = By.xpath("//label[contains(text(),'Habitaciones')]");

    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");

    By btn4estrellas = By.xpath("//li[contains(.,'Estrellas')]//li[@class='dropdown-subitem'][3]");
    By btn5estrellas = By.xpath("//li[contains(.,'Estrellas')]//li[@class='dropdown-subitem'][2]");
    By btnOfertas = By.xpath("//em/span[contains(text(),' Todas las ofertas')]");
    //em[@class='subitem-label filters-text-label']//span[contains(text(),' Todas las ofertas')]
    By btnHotel = By.xpath("//button[@class='eva-3-btn -md -primary -eva-3-fwidth']//child::em[contains(text(),'Ver detalle')]");
    By campoDestino = By.xpath("//input[contains(@class,'sbox-main')]");
    By listaElementos = By.cssSelector("div.ac-container ul>li");
    By errorFound = By.cssSelector(".ac-group-hint-error");
    By Ordenar = By.xpath ("//aloha-select[@class='sorting-select']//select[@class='select-tag']/option");
    By Hotel = By.xpath("//span[contains(text(),'Libertador Hotel')]");
    By Oferta = By.xpath(" //em[@class='subitem-label filters-text-label']//span[contains(text(),' Todas las ofertas')]");
    By btnAgregarMenores = By.cssSelector("._pnlpk-stepper-minors .sbox-3-icon-plus");


    By listaEdad = By.cssSelector("._pnlpk-minors-age-select-wrapper select");
    By listaEdad2 = By.xpath("//select[@class='select-tag']//following::select");



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

    public void agregarMenores() {
        clickear(btnPasajeros);

        for (int j = 0; j < 2; j++){

            clickear(btnAgregarMenores);
        }
        seleccionarElementoPorTexto(listaEdad ,"10 años");
        seleccionarElementoPorTexto(listaEdad2 ,"12 años");
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
        clickear(Hotel);

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