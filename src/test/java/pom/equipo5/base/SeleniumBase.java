package pom.equipo5.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumBase {

    WebDriver driver;

    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }

    public void irUrl(String URL){
        driver.get(URL);
    }

    public WebElement encontrarElemento(By localizador){
        return driver.findElement(localizador);
    }

    public WebElement encontrarElementoDesde(WebElement elementFrom, By localizador){
        return elementFrom.findElement(localizador);
    }

    public List<WebElement> encontrarElementos(By localizador){
        return  driver.findElements(localizador);
    }

    public List<WebElement> encontrarElementosDesde(WebElement elementFrom, By localizador){
        return elementFrom.findElements(localizador);
    }

    public void clickear(By localizador){
        encontrarElemento(localizador).click();
    }

    public void clickear(WebElement element){
        element.click();
    }

    public void escribirEnInput(By localizador, String texto){
        encontrarElemento(localizador).sendKeys(texto);
    }

    public void escribirEnInput(WebElement element, String texto){
        element.sendKeys(texto);
    }

    public void limpiarInput(By localizador){
        encontrarElemento(localizador).clear();
    }

    public void seleccionarOpcion(By localizador, String texto){
        Select select = new Select(encontrarElemento(localizador));
        select.selectByValue(texto);
    }

    public WebElement esperarElementoClickeable(By localizador, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        return espera.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public void esperarPresenciaElemento(By localizador, int time) {
        WebDriverWait espera;
        espera = new WebDriverWait(driver, time);
        espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public void esperarNumeroDeVentanas(int cantidad,int tiempoEnSegundos){
        WebDriverWait espera = new WebDriverWait(driver, tiempoEnSegundos);
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void cambiarVentana(){
        esperarNumeroDeVentanas(2,10);
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public String obtenerTexto(By localizador){
        return encontrarElemento(localizador).getText();
    }

    public String obtenerTexto(WebElement element){
        return element.getText();
    }

    public String obtenerAtributo(By localizador, String atributo){
        return encontrarElemento(localizador).getAttribute(atributo);
    }
    public String obtenerAtributo(WebElement element, String atributo){
        return element.getAttribute(atributo);
    }

    public boolean estaDesplegado(WebElement element){
        return element.isDisplayed();
    }
}
