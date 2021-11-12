package pom.equipo6.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
    //Atributos
    WebDriver driver;

    //Constructor para traernos el driver
    public SeleniumBase(WebDriver driver){
        this.driver=driver;
    }
    //Metodo Wrapper - Envoltorio
    public WebElement findItem(By locator){
        return driver.findElement(locator);
    }

    public void goUrl(String URL){
        driver.get(URL);
    }

    public void click(By locator){
        findItem(locator).click();
    }

    public void clear(By locator){
        findItem(locator).clear();
    }

    public void waitExplicitClick(By locator, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        espera.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void fieldsTextDestino(By locator){
        findItem(locator).sendKeys("Cordoba");
    }
    public void fieldSecondTextDestino(By locator){
        findItem(locator).sendKeys("Buenos Aires");
    }
    public void switchVentana(By locator,int number){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,number);
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();

        //Si aparece una nueva ventana, debe trabajar en la nueva ventana
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
