package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

import java.util.List;

public class VFTrasladoPage extends SeleniumBase {
    public VFTrasladoPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnBuscar = By.xpath("//*[@id='searchbox']//*[text()='Buscar']");
    By inputOrigen = By.xpath("//label[contains(text(),'Desde')]/following-sibling::input");
    By inputDestino = By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input");
    By primeraSugerencia = By.xpath("//div[contains(@class,'ac-wrapper') and contains(@class,'-show')]//li");
    By inputFechaArribo = By.xpath("//input[@placeholder='Arribo']");
    By inputFechaPartida = By.xpath("//input[@placeholder='Partida']");
    By selectHoraArribo = By.cssSelector(".sbox-time-arrival");
    By selectHoraPartida = By.cssSelector(".sbox-time-departure");
    By fechasCalendario = By.cssSelector("._dpmg2--show ._dpmg2--month ._dpmg2--available ._dpmg2--date-number");
    By casillaHaciaAeropuerto = By.xpath("//span[contains(text(),' Hacia el aeropuerto')]");
    By btnPasajeros = By.cssSelector(".sbox-distribution .input-container");
    By btnAgregarAdulto = By.cssSelector("._pnlpk-stepper-adults .sbox-3-icon-plus");
    By btnAgregarMenor = By.cssSelector("._pnlpk-stepper-minors .sbox-3-icon-plus");
    By selectMenor = By.cssSelector("._pnlpk-minors-age-select-wrapper select");
    By btnConfirmarPasajeros = By.xpath("//a[contains(text(),'Aplicar')]");

    //Datos ingresados
    private String aeropuerto = "Aeropuerto Arturo Merino Benitez";
    private String alojamiento = "Hotel W Santiago - Isidora Goyenechea";

    //Acciones
    public void realizarLaBusqueda(){
        clickear(btnBuscar);
    }

    public void rellenarFormulario(){
        escribirEnInput(inputOrigen, aeropuerto);
        clickear(primeraSugerencia);
        escribirEnInput(inputDestino, alojamiento);
        clickear(primeraSugerencia);
        clickear(inputFechaArribo);
        List<WebElement> fechas = encontrarElementos(fechasCalendario);
        clickear(fechas.get(10));
        seleccionarOpcion(selectHoraArribo, "480");
    }

    public void rellenarFormularioHaciaAeropuerto(){
        clickear(casillaHaciaAeropuerto);
        escribirEnInput(inputOrigen, alojamiento);
        clickear(primeraSugerencia);
        escribirEnInput(inputDestino, aeropuerto);
        clickear(primeraSugerencia);
        clickear(inputFechaPartida);
        List<WebElement> fechas = encontrarElementos(fechasCalendario);
        clickear(fechas.get(10));
        seleccionarOpcion(selectHoraPartida, "480");
        clickear(btnPasajeros);
        clickear(btnAgregarAdulto);
        clickear(btnAgregarMenor);
        seleccionarOpcion(selectMenor, "13");
        clickear(btnConfirmarPasajeros);
    }

    public String getAeropuerto() {return aeropuerto; }

    public String getAlojamiento() {
        return alojamiento;
    }

}
