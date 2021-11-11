package pom.mentoria.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void irUrl(String URL){
        driver.get(URL);
    }

    public void clickear(By localizador){
        encontrarElemento(localizador).click();
    }

    public void esperaExplicitaElementoClickeable(By localizador, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        espera.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public String obtenerTexto(By localizador){
        return encontrarElemento(localizador).getText();
    }



}
