package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import pom.equipo4.base.SeleniumBase;

public class VFAlojamientosPage extends SeleniumBase {

    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By cajaBusquedaDestino = By.cssSelector("div.input-container .sbox-destination");
    By listaDestinoDesplegable = By.cssSelector("li.item");
    By chkNoHeDecididoFecha = By.xpath("//label[@class='checkbox-label']");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By cbOrdenarPor = By.id("sorting");
    By cbCambioMoneda = By.id("currency");
    By chkList = By.xpath("//label[starts-with(@class,'checkbox-label')]");
    By FAQList = By.cssSelector(".-detail-section-padding .dropdown-item");
    By tituloAlojamientoSelect = By.xpath("//span[@class='accommodation-name eva-3-h2']");
    By seccionHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnRestar = By.cssSelector("a.steppers-icon-left ");
    By btnAplicar = By.cssSelector("a._pnlpk-apply-button");
    By chkfiltros = By.xpath("//label[starts-with(@class,'checkbox-label')]");
    By chkFiltroWifiZonasComunes = By.xpath("//span[contains(text(),'Wi-Fi gratis en zonas comunes')]");
    By filtroWifiZonasComunes = By.xpath("//em[contains(text(),'Wi-Fi gratis en zonas comunes')]");
    By resultHotels = By.id("hotels");
    By textComentario = By.cssSelector("a.scroll-to-reviews");
    By seccSolitario = By.xpath("//label[contains(text(),'En solitario')]");
    By comentarioSolitario = By.xpath("//span[contains(text(),'Viajó solo/a ')]");

    //By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");

    public void irAlojamientoDesdeHome(){
        clickear(btnAlojamiento);
    }

    public void ingresarDestino(String destino){
        ingresarTexto(cajaBusquedaDestino,destino);
        esperaExplicitaElementoClickeable(listaDestinoDesplegable,10);
        ingresarKeyEnter(cajaBusquedaDestino);
    }

    public void selectSinFecha(){
        clickear(chkNoHeDecididoFecha);
    }

    public void confirmarBusqueda(){
        clickear(btnBuscar);
    }

    public void filtrarMejorPuntuacion(){
        selectMejorPuntuacion(cbOrdenarPor);
    }

    public void filtrarMonedaDolarPorLista(){
        selectMonedaDolar(cbCambioMoneda);
    }


    public void selectAlojamiento(String alojamiento) throws InterruptedException {
        esperaExplicitaPrescenciaElemento(chkList,10);
        busquedaAlojamiento(alojamiento);
    }

    public void mostrarFAQ(){
        recorrerLista(FAQList);
    }

    public void checkTituloText(String titulo){
        assertComparaString(tituloAlojamientoSelect,titulo);
    }


    public void selectMejorPuntuacion(By localizador){
        Select s = new Select(encontrarElemento(localizador));
        s.selectByVisibleText("Mejor puntuación");
    }

    public void selectMonedaDolar(By localizador){
        Select s = new Select(encontrarElemento(localizador));
        s.selectByVisibleText("Dólar");
    }


    public void busquedaAlojamiento(String alojamiento) throws InterruptedException {
        Thread.sleep(1500);
        encontrarElemento(By.xpath("//a[contains(text(),'" + alojamiento + "')]")).click();
        Thread.sleep(1500);
        selectPestana(1);
    }

    public void diminuirUnAdultoEnHabitacion() {
        clickear(seccionHabitaciones);
        clickear(btnRestar);
        clickear(btnAplicar);
    }


    public void filtrarZonaWifiGratisEnZonasComunes() {

        esperaExplicitaPrescenciaElemento(chkfiltros, 10);
        clickear(filtroWifiZonasComunes);
        esperaExplicitaPrescenciaElemento(chkFiltroWifiZonasComunes, 10);
    }


    public void filtrarPrecioMayorAMenor() {

        selectprecioMayorAMenor(cbOrdenarPor);
    }

    public void selectprecioMayorAMenor(By localizador) {
        Select s = new Select(encontrarElemento(localizador));
        s.selectByVisibleText("Precio: mayor a menor");
    }

    public void selectAlojamientoHotel(String alojamiento) throws InterruptedException {
        esperaExplicitaPrescenciaElemento(resultHotels, 10);
        busquedaAlojamiento(alojamiento);

    }


    public void irSeccionComentariosEnSolitario(){

        clickear(textComentario);
        clickear(seccSolitario);


    }


    public void checkComentarioSolitario(String comentario){

        assertComparaString(comentarioSolitario, comentario );

    }









}

