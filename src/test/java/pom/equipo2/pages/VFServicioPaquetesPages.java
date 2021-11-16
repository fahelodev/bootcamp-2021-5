package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo2.base.SeleniumBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VFServicioPaquetesPages extends SeleniumBase {

    public VFServicioPaquetesPages(WebDriver driver) {
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
    By mensajeAlerta = By.cssSelector("div._pnlpk-tooltip");
    By mensajeAlerta2 = By.xpath("//span[contains(text(),'El destino debe ser diferente del origen.')]");
    By listaFechaUltimoMes = By.xpath("//div[@class='_dpmg2--month _dpmg2--o-3']//span[contains(text(),'1')]");
    By listaFechaMeses = By.cssSelector("span._dpmg2--date._dpmg2--available");
    String resultado;
    String resultado2;

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
        seleccionarElementoPorTexto(seleccionMes, "Enero 2022");
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

    public void cargarDestino2() {
        ingresarTexto(campoDestino2, "buenos aires");
        seleccionarTextoLista(listaElementos, "Buenos Aires, Ciudad de Buenos Aires, Argentina");
    }

    public void verificarLimitePersonas() {

        List<WebElement> options_list = encontrarElementos(mensajeAlerta);
        resultado = "";
        for (WebElement l : options_list) {
            resultado += l.getText();
        }
        assertEquals("Solo puedes hacer búsquedas de hasta 8 personas", resultado);
    }

    public void verificarDestinoOrigenDistinto() {

        resultado2 = obtenerTexto(mensajeAlerta2);

        assertEquals("El destino debe ser diferente del origen.", resultado2);

    }

    public void cargarFechas() {
        clickear(btnSeleccionFechaIda);
        seleccionarFecha(listaFechaUltimoMes, "1");
        seleccionarFecha(listaFechaMeses, "11");
    }

    public void confimarBusqueda() {
        clickear(btnBuscar);
    }
}

