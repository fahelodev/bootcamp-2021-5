package pom.equipo2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumBase {


    //Atributos
    WebDriver driver;

    //Constructor para traernos driver
    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    //Metodos Wrapper - Envoltorio
    public WebElement encontrarElemento(By localizador) {
        return driver.findElement(localizador);
    }

    public List<WebElement> encontrarElementos(By localizador) {
        return driver.findElements(localizador);
    }

    public void irUrl(String URL) {
        driver.get(URL);
    }

    public void clickear(By localizador) {
        encontrarElemento(localizador).click();
    }

    public void esperaExplicitaElementoClickeable(By localizador, int time) {
        WebDriverWait espera;
        espera = new WebDriverWait(driver, time);
        espera.until(ExpectedConditions.elementToBeClickable(localizador));
    }
    public void esperaExplicitaPrecenciaElementos(By localizador, int time) {
        WebDriverWait espera;
        espera = new WebDriverWait(driver, time);
        espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public String obtenerTexto(By localizador) {
        return encontrarElemento(localizador).getText();
    }

    public void ingresarTexto(By localizador, String texto) {
        encontrarElemento(localizador).sendKeys(texto);
    }

    public void seleccionarTextoLista(By localizador, String texto) {
        List<WebElement> listaAlojamientos = encontrarElementos(localizador);

        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals(texto)) {
                elemento.click();
                break;
            }
        }
    }

    public void seleccionarFecha(By localizador, String fecha){
        List<WebElement> listaFechas = encontrarElementos(localizador);
        for (WebElement elemento:listaFechas) {
            if(elemento.getText().equals(fecha)) {
                elemento.click();
                break;
            }
        }

    }

    public void seleccionarElementoPorValor(By localizador,String Valor){
        Select selector = new Select(encontrarElemento(localizador));
        selector.selectByValue(Valor);
    }
    public void seleccionarElementoPorTexto(By localizador,String texto){
        Select selector = new Select(encontrarElemento(localizador));
        selector.selectByVisibleText(texto);
    }

    public void ingresarTextoBorrandoElPorDefecto(By localizador, String texto){
        encontrarElemento(localizador).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        encontrarElemento(localizador).sendKeys(texto);

    }





}