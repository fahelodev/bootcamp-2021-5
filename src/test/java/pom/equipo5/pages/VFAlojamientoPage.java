package pom.equipo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

import java.util.List;

public class VFAlojamientoPage extends SeleniumBase {
    public VFAlojamientoPage(WebDriver driver) {
        super(driver);
    }
    //atributos - objeto a guardar
    By btnBuscar = By.xpath("//*[@id='searchbox']//*[text()='Buscar']");
    By tooltipsFechas = By.xpath("//*[@id='searchbox']//span[@class='validation-msg' and contains(text(),'fecha')]");
    By inputDestino = By.xpath("//*[@id=\"searchbox\"]//label[text()='Destino']/following::input[1]");
    By primeraSugerencia = By.xpath("//div[contains(@class,'ac-wrapper') and contains(@class,'-show')]//li");
    By inputFechaEntrada = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Entrada']");
    By inputFechaSalida = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Salida']");
    By inputHabitaciones = By.xpath("//*[@id=\"searchbox\"]//label[text()='Habitaciones']");
    By fechasCalendario = By.cssSelector("div._dpmg2--months  span._dpmg2--available");
    By btnSumarAdulto = By.xpath("//div[contains(.,'Adultos') and @class='_pnlpk-itemRow']//a[contains(@class,'sbox-3-icon-plus')]");

    //Datos obtenidos
    private String fechaEntradaIngresada;
    private String fechaSalidaIngresada;

    //Acciones
    public void realizarLaBusqueda(){
        clickear(btnBuscar);
    }

    public void rellenarFormulario(){
        escribirEnInput(inputDestino, "Madrid");
        clickear(primeraSugerencia);
        clickear(inputFechaEntrada);
        List<WebElement> fechas = encontrarElementos(fechasCalendario);
        clickear(fechas.get(2));
        clickear(fechas.get(9));
        clickear(inputHabitaciones);
        clickear(btnSumarAdulto);
        fechaEntradaIngresada = obtenerAtributo(inputFechaEntrada, "value");
        fechaSalidaIngresada = obtenerAtributo(inputFechaSalida, "value");
    }

    //Verificaciones
    public  void verificarPresenciaTooltipsFecha(){
        List<WebElement> tooltips = encontrarElementos(tooltipsFechas);
        for (WebElement tooltip: tooltips ) {
            Assert.assertTrue(tooltip.isDisplayed());
        }
    }

    public String getFechaEntradaIngresada() {
        return fechaEntradaIngresada.substring(4).trim();
    }

    public String getFechaSalidaIngresada() {
        return fechaSalidaIngresada.substring(4).trim();
    }
}
