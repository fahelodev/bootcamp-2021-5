package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo2.base.SeleniumBase;

public class VFPaquetesPages extends SeleniumBase {

    public VFPaquetesPages(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar


    By campoOrigen = By.xpath("//input[contains(@class,'sbox-places-first')]");
    By campoDestino = By.xpath("//input[contains(@class,'sbox-places-second')]");
    By btnOpcionFecha = By.xpath("//span[contains(text(),'Todavía no he decidido la fecha')]");
    By seleccionMes = By.xpath("//select[contains(@class,'month')]");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By listaElementos = By.cssSelector("div.ac-container ul>li");
    By btnHabitacion = By.cssSelector("div.sbox-distri-container");
    By btnAumetarAdultos = By.xpath("//div[contains(@class,'_pnlpk-dynamicContent')]/following:: label[contains(text(),'A')] /following::a[contains(@class,'plus')] ");
    By btnAumetarMenores = By.xpath("//div[contains(@class,'_pnlpk-dynamicContent')]/following:: label[contains(text(),'M')] /following::a[contains(@class,'plus')] ");
    By campoDestino2 = By.xpath("//input[contains(@class,'sbox-places-second')]");
    By btnFechaIda = By.cssSelector("div.ac-container ul>li");
    By btnSeleccionFechaIda = By.cssSelector("input.input-tag.sbox-checkin-date");
    By btnSleccionFechaVuelta = By.cssSelector("span._dpmg2--date._dpmg2--available");


    public void cargarOrigen() {
        ingresarTexto(campoOrigen, "Cordoba");
        seleccionarTextoLista(listaElementos, "Córdoba, Córdoba, Argentina");
    }

    public void cargarDestino() {
        ingresarTexto(campoDestino, "Cordoba");
        seleccionarTextoLista(listaElementos, "Córdoba, Córdoba, Argentina");

    }

    public void confirmarFechaNoDecidida() {
        clickear(btnOpcionFecha);
    }

    public void confirmarMes() {
        seleccionarMes(seleccionMes);
    }

    public void confirmarBusqueda() {
        clickear(btnBuscar);
    }

    public void agregarPersonasHabitacion() {
        clickear(btnHabitacion);
    }

    public void agregarTresAdultos() {

        seleccionarPersonas(btnAumetarAdultos, 3);
    }

    public void agregarTresMenores() {

        seleccionarPersonas(btnAumetarMenores, 3);
    }

    public void cargarDestino2 () {
        ingresarTexto(campoDestino2, "buenos aires");
        seleccionarTextoLista(listaElementos, "Buenos Aires, Ciudad de Buenos Aires, Argentina");
    }

}


