package pom.equipo3.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SeleniumBase {

    //Atributos
    WebDriver driver;

    //Constructor para traernos driver
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }

    //Metodos Wrapper - Envoltorio
    public WebElement encontrarElemento(By localizador){
        return driver.findElement(localizador);
    }
    public List<WebElement> encontrarElementos(By localizador) {
        return driver.findElements(localizador);
    }

    public void irUrl(String URL){
        driver.get(URL);
    }

    public void clickear(By localizador) {
        encontrarElemento(localizador).click();
    }

    //Selecciona la lista de destino y origen

    public void seleccionarTextoLista(By localizador, String texto) {
        List<WebElement> listaAlojamientos = encontrarElementos(localizador);

        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals(texto)) {
                elemento.click();
                break;
            }
        }
    }

    public void asignarFechaDisponible(int dias){
        List<WebElement> fechas = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        fechas.get(dias).click();
    }



    public void esperaExplicitaElementoClickeable(By localizador, int time){
        WebDriverWait esperae;
        esperae = new WebDriverWait(driver,time);
        esperae.until(ExpectedConditions.elementToBeClickable(localizador));
    }



    public void seleccionarElementoPorTexto(By localizador, String texto) {
        Select selector = new Select(encontrarElemento(localizador));
        selector.selectByVisibleText(texto);
    }

    public String obtenerTexto(By localizador){
        return encontrarElemento(localizador).getText();
    }

    public void ingresarTexto(By localizador, String texto) {
        encontrarElemento(localizador).sendKeys(texto);

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

  public void dormir(int mseconds) throws InterruptedException {
        Thread.sleep(mseconds);
    }


}
