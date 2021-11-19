package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

import java.util.List;

public class VFPaquetePage extends SeleniumBase {
    public VFPaquetePage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnBuscar = By.xpath("//*[@id='searchbox']//*[text()='Buscar']");
    By txtIdaYVuelta = By.xpath("//div[contains(text(),'Vuelo ida y vuelta')]");
    By inputOrigen = By.xpath("//label[contains(text(),'Origen')]/following-sibling::input");
    By inputDestino = By.xpath("//label[contains(text(),'Destino')]/following-sibling::input");
    By inputSegundoDestino = By.xpath("//label[contains(text(),'Segundo destino')]/following-sibling::input");
    By primeraSugerencia = By.xpath("//div[contains(@class,'ac-wrapper') and contains(@class,'-show')]//li");
    By inputFechaIda = By.xpath("//input[@placeholder='Ida']");
    By inputFechaHasta = By.xpath("//input[@placeholder='Hasta']");
    By fechasCalendario = By.cssSelector("._dpmg2--show ._dpmg2--month ._dpmg2--available ._dpmg2--date-number");
    By btnDosAlojamientos = By.cssSelector(".sbox-bundle-vhh input");
    //m
    By primerPaqueteRecomendado = By.cssSelector("img.offer-card-image-main");
    By modalCostoFecha = By.cssSelector("a.date-box");

    //Datos ingresados
    private String origen = "Santiago de Chile, Santiago, Chile";
    private String destino = "Miami Beach, Florida";
    private String segundoDestino = "Miami, Florida";


    //Acciones
    public void realizarLaBusqueda(){
        clickear(btnBuscar);
    }

    public void rellenarFormularioDosAlojamientos(){
        clickear(btnDosAlojamientos);
        esperarPresenciaElemento(txtIdaYVuelta, 15);
        escribirEnInput(inputOrigen, origen);
        clickear(primeraSugerencia);
        escribirEnInput(inputDestino, destino);
        clickear(primeraSugerencia);
        clickear(inputFechaIda);
        List<WebElement> fechasIda = encontrarElementos(fechasCalendario);
        clickear(fechasIda.get(10));
        clickear(fechasIda.get(20));
        clickear(inputFechaHasta);
        List<WebElement> fechasHasta = encontrarElementos(fechasCalendario);
        clickear(fechasHasta.get(5));
        escribirEnInput(inputSegundoDestino, segundoDestino);
        clickear(primeraSugerencia);
    }

    public void selecionarPrimerPaqueteRecomendado(){
        esperarPresenciaElemento(primerPaqueteRecomendado, 15);
        clickear(primerPaqueteRecomendado);
        esperarPresenciaElemento(modalCostoFecha, 15);
        clickear(modalCostoFecha);
        cambiarVentana();
    }

    public void rellenarFormularioUnAlojamiento(){
        escribirEnInput(inputOrigen, origen);
        clickear(primeraSugerencia);
        escribirEnInput(inputDestino, destino);
        clickear(primeraSugerencia);
        clickear(inputFechaIda);
        List<WebElement> fechasIda = encontrarElementos(fechasCalendario);
        clickear(fechasIda.get(10));
        clickear(fechasIda.get(15));
    }

    public String getOrigen() {return origen; }

    public String getDestino() {
        return destino;
    }
    public String getSegundoDestino() {
        return segundoDestino;
    }


}
